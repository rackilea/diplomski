public class ClassToTest {

    private CloudService service;

    public ClassToTest(CloudService service) {
        this.service = service;
    }

    public String moveFilesToCloud(String path, String documentclass, String objStore) {
        log.info("Moving files to cloud.");
        String docId = StringUtils.EMPTY;
        try {
            docId = service.uploadDocument(path,documentclass,objStore,"");
        } catch (CloudException e) {
            log.info("* Error uploading reports to cloud *" + e.getMessage());
        }
        return docId;
    }
}