@XmlRootElement(name = "files")
public class FileManagementList {

    @XmlElement(name = "file")
    private List<FileManagement> files;

    public FileManagementList() {
        this(Collections.<FileManagement>emptyList());
    }

    public FileManagementList(List<FileManagement> files) {
        this.files = files;
    }
}