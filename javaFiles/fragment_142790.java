@Override
public boolean uploadCV(User user, MultipartFile file) {
    String fileContentType = file.getContentType();
    if(contentTypes.contains(fileContentType)) {
        // You have the correct extension
        // rest of your code here
    } else {
        // Handle error of not correct extension
    }
}