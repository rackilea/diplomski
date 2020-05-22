import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

    // Show page for upload
    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public ModelAndView showUploadFilePage() {
        return new ModelAndView("fileUpload", "upload", null);
    }

    // Get multipart file and save it
    @RequestMapping(value = "/uploadNewFile", method = RequestMethod.POST)
    public String save(@RequestParam("file") MultipartFile file) {
        // Save it to i.e. database
        // dao.save(file);
        return "fileUpload";
    }

    // Downloads file. I.e. JPG image
    @RequestMapping(value = "/download/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody HttpEntity<byte[]> getFile(
        @PathVariable("id") Integer id) throws IOException {

        byte[] file= dao.get(id).getImage();
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition", "attachment; filename=Image");
        header.setContentLength(file.length);

        return new HttpEntity<byte[]>(file, header);
    }
}