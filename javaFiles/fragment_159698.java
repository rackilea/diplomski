Class<?> c = X.class;  // or if you have X x, then x.getClass();
for (Annotation ann : c.getAnnotations()) {
  if (ann instanceof BaseProp) {   // make sure it's your annotation
    BaseProp bp = (BaseProp)ann;
    bp.category();  // do something here
  }
}