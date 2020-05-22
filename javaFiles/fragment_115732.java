AtomicInteger ai = new AtomicInteger(); 
List<ObjectAttribute> objLst = Arrays.stream(newImageVal)
.map(img-> {
   ObjectAttribute object = new ObjectAttribute();
   object.setImageName(img);
   object.setImageId(ai.getAndIncrement()); 
   return obj;
 }).collect(Collectors.toList())