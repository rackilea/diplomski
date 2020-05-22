public static boolean equals(Object[] a, Object[] b) {
    if(a.length != b.length) return false;
    outer: for(Object aObject : a) {
         for(Object bObject : b) {
              if(a.equals(b)) continue outer;
         }
         return false;
    }
    return true;
}