@Path("/zip")
public class ZipResource {

    @POST
    @Consumes({"application/zip", "application/xml"})
    public Response postZipFile(InputStream is, @Context HttpHeaders headers) throws Exception {
        String contentType = headers.getHeaderString(HttpHeaders.CONTENT_TYPE);
        String returnString = null;

        if (null != contentType) switch (contentType) {
            case "application/xml":
                returnString = readXmlFile(is);
                break;
            case "application/zip":
                returnString = readZipFile(is);
                break;
        }

        return Response.ok(returnString).build();
    }

    private String filePartToString(InputStream is, int size) throws Exception {
        String xml;
        byte[] buff = new byte[size];
        is.read(buff, 0, size);
        return new String(buff);
    }

    private String readXmlFile(InputStream is) {
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(is, writer, "utf-8");
        } catch (IOException ex) {
            Logger.getLogger(ZipResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return writer.toString();
    }

    private String readZipFile(InputStream is) {
        StringBuilder builder = new StringBuilder("==== Data ====\n");
        try (ZipInputStream zip = new ZipInputStream(is)) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}