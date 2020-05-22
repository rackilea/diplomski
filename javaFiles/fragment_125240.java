Transport t = new REST();
Flickr f = new Flickr("key", "secret", t);
PhotoList list = f.getPhotosetsInterface().getPhotos("setId", 100, 1);
for (Iterator iterator = list.iterator(); iterator.hasNext();) {
    Photo photo = (Photo) iterator.next();
    File file = new File("/tmp/" + photo.getId() + ".jpg");
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    b.write(photo.getOriginalAsStream());
    FileUtils.writeByteArrayToFile(file, b.toByteArray());
}