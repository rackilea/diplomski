public class Garbage implements Serializable {

    private String filename;
    private String description;
    private String uploadDate;

    public Garbage(String filename, String description, String uploadDate) {
        this.filename = filename;
        this.description = description;
        this.uploadDate = uploadDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

}