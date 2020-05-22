@POST
@Path("/upload/{primaryKey}")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces("image/jpg")
public String uploadImage(@FormParam("image") String image, @PathParam("primaryKey") String primaryKey) throws SQLException, FileNotFoundException
{
    String result = "false";
    FileOutputStream fos;

    fos = new FileOutputStream("img/" + primaryKey + ".jpg");

    // decode Base64 String to image
    try
    {

        byte byteArray[] = Base64.getMimeDecoder().decode(image);
        fos.write(byteArray);

        result = "true";
        fos.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    return result;
}