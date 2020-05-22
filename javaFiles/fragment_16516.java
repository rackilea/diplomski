InputStream inputStream =   new URL(url).openStream();  
    File file = File.createTempFile("tmp", ".txt", new File(System.getProperty("user.dir")));
    byte[] binary = IOUtils.toByteArray(inputStream);
    FileUtils.writeByteArrayToFile(file, binary);
    UploadedMultipartFile multipartFile = new UploadedMultipartFile(file, file.length(), "jpg",
                "formParameter", fileName);
    MultipartFileWrapper multipartFileWrapper = new MultipartFileWrapper();
    multipartFileWrapper.setMultipartFile(multipartFile);
    redirectAttributes.addFlashAttribute(multipartFileWrapper);
    return "redirect:/member/uploadImage";