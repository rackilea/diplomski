@RequestMapping("/pictures/{filename}.{extension}")
public void getPicture(@PathVariable String filename,
        @PathVariable String extension, OutputStream outputStream,
        HttpServletResponse response) {

    DateTime cachePeriod = new DateTime();
    cachePeriod = cachePeriod.plusDays(5);
    response.setDateHeader("Expires", cachePeriod.getMillis());
    pictureService.writePicture(filename + "." + extension, outputStream);
}