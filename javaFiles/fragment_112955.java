MyObj obj = myObjList
   .stream()
   .filter(o -> ...)
   .map(o -> {
       // I do some stuff here

       // I need here set obj to o, but I got error
       return o;
   })
   .findAny()
   .orElse(null);