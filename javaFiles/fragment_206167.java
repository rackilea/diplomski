@RequestMapping(value = "/getmathresume", method = RequestMethod.GET)
public void getMathResume(HttpServletResponse response) {
    try {
        File file = new File("poi-generated-file.xlsx");
        Files.copy(file.toPath(), response.getOutputStream());
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        String contentDisposition = String.format("attachment; filename=%s", file.getName());
        int fileSize = Long.valueOf(file.length()).intValue();

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", contentDisposition);
        response.setContentLength(fileSize);
    }catch (FileNotFoundException e) {
        System.out.println(e);
    } catch (IOException e) {
        e.printStackTrace();
    }
}