@Controller
public class MyController {

    @Value("#{myProps['uploadFolder']}")
    private String uploadFolder

    @Value("#{myProps['downloadFolder']}")
    private String downloadFolder

    @RequestMapping("myPage")
    public String loadPage(ModelMap m) {
        m.addAttribute("uploadFolder", uploadFolder);
        m.addAttribute("downloadFolder", downloadFolder);
        return "myPage";
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }
    public void setDownloadFolder(String downloadFolder) {
        this.downloadFolder = downloadFolder;
    }
}