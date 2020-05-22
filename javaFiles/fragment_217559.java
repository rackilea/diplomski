// get the email field 
Field emailAddressField = MyClass.class.getDeclaredField("emailAddresses");

// the field's type is both parameterized and annotated,
// cast it to the right type representation
AnnotatedParameterizedType annotatedParameterizedType =
        (AnnotatedParameterizedType) emailAddressField.getAnnotatedType();

// get all type parameters
AnnotatedType[] annotatedActualTypeArguments = 
        annotatedParameterizedType.getAnnotatedActualTypeArguments();

// the String parameter which contains the annotation
AnnotatedType stringParameterType = annotatedActualTypeArguments[0];

// The actual annotation
Annotation emailAnnotation = stringParameterType.getAnnotations()[0]; 

System.out.println(emailAnnotation);  // @Email()