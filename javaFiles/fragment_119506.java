@GET
@Path("/id/{userId}/{type}/{date}")
@Nullable
@Produces(MediaType.APPLICATION_JSON)
List<Exercise> findExercises(
        @PathParam("userId") Long userId,
        @PathParam("type") String type,
        @PathParam("date") String date);