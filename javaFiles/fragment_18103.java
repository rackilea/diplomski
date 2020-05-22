@RestController
@RequestMapping("/api")
public class CloudStorageHelper  {

    Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\sachinthah\\Downloads\\MCQ project -1f959c1fc3a4.json"));
    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

    public CloudStorageHelper() throws IOException {
    }

    @SuppressWarnings("deprecation")
    @RequestMapping(method = RequestMethod.POST, value = "/imageUpload112")
    public String uploadFile(@RequestParam("fileseee")MultipartFile fileStream)
            throws IOException, ServletException {
        BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
        String bucketName = "mcqimages";
        checkFileExtension(fileStream.getName());
        DateTimeFormatter dtf = DateTimeFormat.forPattern("-YYYY-MM-dd-HHmmssSSS");
        DateTime dt = DateTime.now(DateTimeZone.UTC);

        String fileName = fileStream.getOriginalFilename();

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(User.ofAllUsers(), Role.READER))))
                .build(),
        fileStream.getInputStream());

        System.out.println(blobInfo.getMediaLink());

        // sachintha added a comma after the link to identify the link that get generated
        return blobInfo.getMediaLink() + ",";
    }


private void checkFileExtension(String fileName) throws ServletException {
    if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
        String[] allowedExt = {".jpg", ".jpeg", ".png", ".gif"};
        for (String ext : allowedExt) {
            if (fileName.endsWith(ext)) {
                return;
            }
        }
        throw new ServletException("file must be an image");
    }
}