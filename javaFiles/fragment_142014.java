File f = new File("C://xxx/test.txt");
Part[] parts = {
    new FilePart("test", f)
};
postMethod.setRequestEntity(
    new MultipartRequestEntity(parts, postMethod.getParams())
    );