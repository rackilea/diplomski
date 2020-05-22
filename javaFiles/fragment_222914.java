aList.stream.forEach(a -> {
   try {
    bList.addAll(getAValues(a))
   } catch(CustomizedException cex) {
     // handle it
   }
});