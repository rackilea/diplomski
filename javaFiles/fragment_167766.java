public static Class<?> generateMockEndpoint(MockEndpointDefinition def) {

    ClassPool pool = ClassPool.getDefault();

    CtClass cc = pool.makeClass(def.getServiceName() + "Endpoint");
    ClassFile classFile = cc.getClassFile();
    ConstPool constpool = classFile.getConstPool();

    classFile.addAttribute(addSingleAnnotation(constpool, Endpoint.class.getName()));

    for (MockEndpointDefinition.MockOperation operation : def.getOperations()) {
        try {
            CtMethod mthd = CtNewMethod.make(templateMethod(operation, def.getNamespace()), cc);
            ConstPool mthdConstPool = mthd.getMethodInfo().getConstPool();

            // add method annotations
            AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
            Annotation[] annotations = new Annotation[]{
                    addAnnotation(mthdConstPool, ResponsePayload.class.getName()),
                    addAnnotation(mthdConstPool, PayloadRoot.class.getName(),
                            new String[][]{
                                    new String[]{"namespace", def.getNamespace()},
                                    new String[]{"localPart", operation.getLocalPart()}
                            }
                    )
            };
            annotationsAttribute.setAnnotations(annotations);
            mthd.getMethodInfo().addAttribute(annotationsAttribute);

            // add method's parameter annotation
            ParameterAnnotationsAttribute parameterAttributeInfo = new ParameterAnnotationsAttribute(mthdConstPool, ParameterAnnotationsAttribute.visibleTag);
            ConstPool parameterConstPool = parameterAttributeInfo.getConstPool();

            Annotation annotation = addAnnotation(parameterConstPool, RequestPayload.class.getName());
            Annotation[][] annotations2 = new Annotation[][]{
                new Annotation[] {annotation}
            };
            parameterAttributeInfo.setAnnotations(annotations2);
            mthd.getMethodInfo().addAttribute(parameterAttributeInfo);

            cc.addMethod(mthd);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    try {
        return cc.toClass();
    } catch (Exception e) {
        throw new IllegalStateException("Custom Endpoint class creation failed", e);
    }
}