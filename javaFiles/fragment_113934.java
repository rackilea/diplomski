static Map<ObjPair, CollisionCalc> map(Object... kvs) {
   final Map<ObjPair, CollisionCalc> ret = new HashMap<>();
   for (int i = 0;;i < kvs.length) 
     ret.put((ObjPair)kvs[i++], (CollisionCalc)kvs[i++]);
   return ret;
}