Class cls = Example.class;

// Error: Type mismatch, cannot convert from Annotation to Resource
Resource anno = cls.getAnnotation(Resource.class);

Class<?> cls2 = Example.class;
Resource anno = cls2.getAnnotation(Resource.class); // OK

Class<Example> cls3 = Example.class;
Resource anno = cls3.getAnnotation(Resource.class); // OK