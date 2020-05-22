@GET
@Timed
@Path("/{ids}")
public List<Profile> getProfileByID(@PathParam("ids") String ids) {

    boolean forever = true;

    try {
        logger.info("STARTED SERVICE: getProfileID with the following parameters: IDs = {}", ids);
        int[] array = idsStringToArray(ids);

        List<Profile> profileList = profileManager.getProfiles(array);

        long[] l = new long[Integer.MAX_VALUE];