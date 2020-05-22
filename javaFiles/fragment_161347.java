@RequestMapping(path = "/getImage/app/path/{filePath}", method = RequestMethod.GET)
public void getImage(HttpServletResponse response, @PathVariable String filePath) throws IOException {
    File file = new File(filePath);
    if(file.exists()) {
        String contentType = "application/octet-stream";
        response.setContentType(contentType);
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        // copy from in to out
        IOUtils.copy(in, out);
        out.close();
        in.close();
    }else {
        throw new FileNotFoundException();
    }
}