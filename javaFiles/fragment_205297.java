int PhotoFileAmount = PhotoArray.length; // use int here to avoid unnecessary boxing / unboxing

for(int i=0; i < PhotoFileAmount; i++){
    String PhotoFileAndPath = (PhotoFolder + '/' + PhotoArrayList.get(i));
    PhotoArrayList.set(i, PhotoFileAndPath);
}