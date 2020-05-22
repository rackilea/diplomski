@Controller
@RequestMapping("/FileUploadController")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.POST)
    protected ModelAndView onSubmit(HttpServletRequest request) throws Exception{
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> /* FileItem */ items = upload.parseRequest(request);

        for (FileItem fileItem : items) {
            if (fileItem.isFormField()) {
//                processFormField(fileItem);
            } else {
                File uploadedFile = new File("/tmp/junk/" + fileItem.getName());
                fileItem.write(uploadedFile);
            }
        }
        return new ModelAndView("index");
    }
}