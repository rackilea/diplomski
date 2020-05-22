HashMap<String, PImage> imageMap = new HashMap<String, PImage>();

void addImage(String key, String imageLocation) {
  imageMap.put(key, loadImage(imageLocation));
}

PImage getImage(String key){
   return imageMap.get(key);
}