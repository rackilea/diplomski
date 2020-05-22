@PostMapping("/")
public String handleFileUpload(@RequestParam("manyfiles") MultipartFile[] files,
                           RedirectAttributes redirectAttributes) {

    for(MultipartFile file : files) {
        //Your upload code
    }
}