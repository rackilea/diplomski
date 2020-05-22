Image image = new Image(resource);
Map<String, String> map = image.getImageTagAttributes();
for (Map.Entry<String,String> foo : map.entrySet()) {
    String key = foo.getKey();
    String value = foo.getValue();

    //output here
}