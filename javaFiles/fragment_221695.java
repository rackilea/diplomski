@Path("{path:(?:[^/]+/){0,4}[^/]+}")
/* Other attributes too... */
public Response getMediaFile(@PathParam("path") String path) {
    File file=new File(MEDIA_HOME_DIR, path);
    if(file.exists()) {
        // Process file
    }
    else {
        // No such file
    }
}