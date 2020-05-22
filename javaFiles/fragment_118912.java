// somewhere accessible to both the constructing and accessing code, such as a
// public static field on the Annotation
Map<Class<? extends Annotation>,Object> annotationMap = new HashMap();

// wherever the instance is constructed
annotationMap.put(MyConfig.class, new MyConfiguration());

// wherever the instance is needed
MyConfiguration myConf = (MyConfiguration)annotationMap.get(MyConfig.class);