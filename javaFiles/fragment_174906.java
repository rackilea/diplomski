@ResponseBody
@RequestMapping("/myurl/{filename:.*}")
public byte[] serveFile(@PathVariable("file"} String file) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
    DbxEntry.File downloadedFile = client.getFile("/" + filename, null, outputStream);
    return outputStream.toByteArray();
}