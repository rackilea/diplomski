public static class ImagesSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        Product p = (Product) jgen.getCurrentValue();

        int num = p.getNumberOfImages();

        List<String> imgs = new ArrayList<String>(num);

        for(int i = 0; i < num; i++) {
            String src = "/include/images/showImage.jsp?"+"id="+p.getId()+"&number="+i;
            imgs.add(src);
        }

        provider.defaultSerializeValue(imgs, jgen);
    }

}