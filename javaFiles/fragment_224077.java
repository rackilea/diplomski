//Create Annotation
MyAnnotationOld oldAnnotation;
MyAnnotation modifiedAnnotation = new MyAnnotation{
public Class<? extends java.lang.annotation.Annotation> annotationType() {return oldAnnotation.annotationType();}
public String propertyWhichShallRemainTheSame() {return oldAnnotation.propertyWhichShallRemainTheSame();}
public String propertyWhichShallBeModified() {return "Modified Thingy";}
}

//Copy Method
Method toCopy;
Method copyMethod = Method.class.getDeclaredMethod("copy", (Class<?>[])null);
copyMethod.setAccessible(true);
Method copiedMethod = (Method) copyMethod.invoke(toCopy, (Object[]) null);

//Add annotation to copied method
Field field = Method.class.getDeclaredField("declaredAnnotations");
field.setAccessible(true);
//Intantiate field !!IMPORTANT!! If you don't do this, the field will be null and thus return an error.
copiedMethod.getAnnotations();
Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) field.get(copiedMethod);
annotations.put(MyAnnotation.class, modifiedAnnotation);