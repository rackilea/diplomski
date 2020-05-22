@RestController
public class FileGenerationResource {
    ...
    @GetMapping("/file/{id}")
    @Timed
    public void getFile(@PathVariable Long id, HttpServletResponse response) throws URISyntaxException, IOException {
        FileInputStream stream = fileService.getFile(id);
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-disposition", "attachment; filename=test.docx");
        IOUtils.copy(stream,response.getOutputStream());
        stream.close();
    }
}