public aspect TransformationAspect {
   pointcut transform(String s) : call(* yourMethodName(..)) && args(s);

   Object around(String s): transform(s) {
     // ... Transform String here
     return proceed(s);
   }
 }