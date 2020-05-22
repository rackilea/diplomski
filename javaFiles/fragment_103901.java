ArrayList<String> urls = new ArrayList<String>();
JSONArray imagesArr = propertiesjsonObject.getJSONArray("images");
for (int i = 0; i < imagesArr.length(); i++) {
    String str_image_url = imagesArr.getString(i);
    urls.add(str_image_url);
}