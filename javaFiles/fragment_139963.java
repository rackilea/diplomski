@RequestMapping(value = "/upload", method = RequestMethod.POST)
public void exampleFileUpload(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
        try {
            byte[] fileBytes = file.getBytes();

            // Persist those bytes using JPA here

        } catch (IOException e) {
            // Exception handling here
        }
    }
}