members += entity.toMethod("dummy", Void.TYPE.typeRef) [
parameters +=  entity.toParameter("someParam", String.typeRef) => [
    annotations += annotationRef("java.lang.Deprecated");
]
body = ''''''
]