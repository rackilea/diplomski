@Path("/zip")
public class ZipResource {

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response postZipFile(InputStream is) throws Exception {
        StringBuilder builder;
        try (ZipInputStream zip = new ZipInputStream(is)) {
            builder = new StringBuilder("==== Data ====\n");
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                String filename = entry.getName();
                if (filename.endsWith(".xml")) {
                    builder.append("name: ").append(entry.getName()).append("\n");
                    String xml = filePartToString(zip, (int) entry.getSize());
                    builder.append("data: ").append(xml).append("\n");
                }
                zip.closeEntry();
            }
        }
        return Response.ok(builder.toString()).build();
    }

    private String filePartToString(InputStream is, int size) throws Exception {
        String xml;
        byte[] buff = new byte[size];
        is.read(buff, 0, size);
        return new String(buff);
    }
}