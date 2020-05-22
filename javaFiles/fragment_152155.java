final DynamicType.Unloaded<? extends Annotation> unloaded = new ByteBuddy()
    .with(TypeValidation.DISABLED)
    .makeAnnotation()
    .name("jdk.Profile+Annotation")
    .make();

final DynamicType.Loaded<? extends Annotation> loaded = unloaded.load(Test.class.getClassLoader());
final Class<? extends Annotation> myBadlyNamedAnnotation = loaded.getLoaded();

System.out.println(myBadlyNamedAnnotation);