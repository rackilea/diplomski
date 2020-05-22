@RestController
public class AdminController {

    @PutMapping("/path/max_file_size")
    public void setMaxFileSize(@ModelAttribute MaxFileSizeDto size) {
        System.out.println(size.getSize());
    }
}