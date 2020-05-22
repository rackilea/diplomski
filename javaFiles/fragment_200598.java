Writer writer = response.getWriter();
writer.write("[");
for (int i = 0; i < r.length; i++) {
     if (i != 0) {
         writer.write(","); // Separate this item from the previous one
     }
     byte[] bytes = MyHelper.decodeImage1(r[i]);
     String base64 = Base64.encodeBytes(bytes);
     writer.write(base64);
}
writer.write("]");