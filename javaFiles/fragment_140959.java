Iterator<Map.Entry<String, Integer>> iterator = 
                           buyingItemEnumerationMap.entrySet().iterator();
while (iterator.hasNext()) {
   Map.Entry<String, Integer> item = iterator.next();
   if(RandomEngine.boolChance(50)){ //will delete?
      iterator.remove();
   }
   //..
}