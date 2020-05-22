String data = "";
ClassPathResource resource = new ClassPathResource("/XML1.xml");
try {
    byte[] dataArr = FileCopyUtils.copyToByteArray(resource.getInputStream());
    data = new String(dataArr, StandardCharsets.UTF_8);
} catch (IOException e) {
    // do whatever
}