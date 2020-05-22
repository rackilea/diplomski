int i = vec.indexOf(null)
   if (i == -1) {
        vec.add(obj);
   } else {
        vec.set(i, obj);
   }