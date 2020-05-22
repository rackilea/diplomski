@RequestMapping("/getFile")
public void getFile(HttpServletResponse response) {
    String address = Services.createFile();
    File file = new File(address);
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-disposition", "attachment; filename=" + file.getName());

    OutputStream out = response.getOutputStream();
    FileInputStream in = new FileInputStream(file);

    // copy from in to out
    IOUtils.copy(in,out);

    out.close();
    in.close();
    file.delete();
}