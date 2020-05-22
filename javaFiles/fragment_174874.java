@Async
public void process(byte[] bs){
    //do some long running processing of bs here
}

@PostMapping("/")
public String handleFileUpload(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {
    upload.process(IOUtils.toByteArray(file));
}