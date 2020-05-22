@RequestMapping(method = RequestMethod.POST, value = "/upload/")
public @ResponseBody String saveUpload(@RequestParam("file") final MultipartFile mpf) throws IOException, ServletException, FileUploadException {
    File file = new File("C:/dest_path/" + mpf.getOriginalFilename());
    FileUtils.writeByteArrayToFile(file, mpf.getBytes());

    return "success";
}