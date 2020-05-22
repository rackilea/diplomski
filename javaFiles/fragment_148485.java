@Path('{filename}')
@GET
public InputStream getIndex(@PathParam("filename") String fileName){
File index = new File("webapp/public/" + fileName);
try {
    return new FileInputStream(index);
} catch (FileNotFoundException e) {
    String s = "ERROR";
    return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
}