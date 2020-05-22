public Configuration addAnnotatedClass(Class annotatedClass)
   {
     XClass xClass = reflectionManager.toXClass(annotatedClass);
    metadataSourceQueue.add(xClass);
    return this;
   }