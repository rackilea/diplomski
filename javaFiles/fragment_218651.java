@PostMapping("/upload")
public String add(@RequestParam("file") MultipartFile file) throws IOException {

    /**
     * save file to temp
     */
    File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
    FileOutputStream o = new FileOutputStream(zip);
    IOUtils.copy(file.getInputStream(), o);
    o.close();

    /**
     * unizp file from temp by zip4j
     */
    String destination = "D:\\destination";
    try {
         ZipFile zipFile = new ZipFile(zip);
         zipFile.extractAll(destination);
    } catch (ZipException e) {
        e.printStackTrace();
    } finally {
        /**
         * delete temp file
         */
        zip.delete();
    }

    return "redirect:/";
}