String PictureTest[] = {"a.jpg","b.png","c.txt", "d.wav", "e.tga"};
ArrayList<String> PictureResult = new ArrayList<String>;

for(String item : PictureTest) {
    if(item.contains(".jpg") || item.contains(".png") || item.contains(".tga") {
        PictureResult.add(item);
    }
}