String mimetype = entity.getMimeType();

// sets response content type
if (mimetype == null) {
    mimetype = "application/octet-stream";
}
response.setContentType(mimetype);
response.setContentLength((int)file.length());
String fileName = (new File(filePath)).getName();

// sets HTTP header
response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");