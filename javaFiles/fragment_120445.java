public void multipartFileToFile(
    MultipartFile multipart, 
    Path dir
) throws IOException {
    Path filepath = Paths.get(dir.toString(), multipart.getOriginalFilename());
    multipart.transferTo(filepath);
}