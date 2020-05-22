import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mypkg.models.UploadedFile;

@Controller
public class FileUploadController  implements HandlerExceptionResolver
{
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUploadForm(Model model)
    {
        model.addAttribute("uploadedFile", new UploadedFile());
        return "/upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String create(UploadedFile uploadedFile, BindingResult result)
    {
        // Do something with the file
        System.out.println("#########  File Uploaded with Title: " + uploadedFile.getTitle());
        System.out.println("#########  Creating local file: /var/test-file-upload/" + uploadedFile.getFileData().getOriginalFilename());

        try
        {

            InputStream in = uploadedFile.getFileData().getInputStream();
            FileOutputStream f = new FileOutputStream(
                    "/var/test-file-upload/" + uploadedFile.getFileData().getOriginalFilename());
            int ch = 0;
            while ((ch = in.read()) != -1)
            {
                f.write(ch);
            }
            f.flush();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    /*** Trap Exceptions during the upload and show errors back in view form ***/
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception)
    {        
        Map<String, Object> model = new HashMap<String, Object>();
        if (exception instanceof MaxUploadSizeExceededException)
        {
            model.put("errors", exception.getMessage());
        } else
        {
            model.put("errors", "Unexpected error: " + exception.getMessage());
        }
        model.put("uploadedFile", new UploadedFile());
        return new ModelAndView("/upload", model);
    }

}

========================================================================