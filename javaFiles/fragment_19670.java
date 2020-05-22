public static void userPhoto(long id) { 
    final User user = User.findById(id); 
    response.setContentTypeIfNotSet(user.photo.type());
    java.io.InputStream binaryData = user.photo.get();
    renderBinary(binaryData);
}