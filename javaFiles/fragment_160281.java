@RequestMapping(value = "/", method = RequestMethod.GET)
public void downloadFile(HttpServletResponse response,
                         HttpServletRequest request) throws IOException
{
    byte[] pdf = createPdf();

    response.setContentType("application/x-download");
    response.setHeader("Content-Disposition", "attachment; filename=foo.pdf");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.getOutputStream().write(pdf);
}