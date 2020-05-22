@RequestMapping(value="/openfile", params ={"path"})
public void openFile(@RequestParam(value="path", required=false) String path, ModelMap model, HttpServletResponse response) throws ServletException {

    try {
        File file = new File(path);
        response.setContentType("application/download");
        response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setContentLength((int) file.length());
        FileInputStream input = new FileInputStream(file);
        BufferedInputStream buf = new BufferedInputStream(input);
        FileCopyUtils.copy(buf, response.getOutputStream());
    } catch (IOException ioe) {
        throw new ServletException(ioe.getMessage());
    } catch (Exception ex) {
        System.out.println("[openfile] Error: " + ex.getMessage());
    }
}