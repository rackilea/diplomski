@POST
    @Path("/saveProjectInfo/{projectId}/{application}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JsonRawValue
    public String saveProjectInfo(SaveBean input,
            @PathParam("projectId") String projectId,
            @PathParam("application") String application) {

        System.out.println("ProjectId provided : " + projectId);
        System.out.println("Application provided : " + application);
        System.out.println("Effort : " + input.getEffort());
        System.out.println("CRC : " + input.getCrc());

        return "Project description saved successfully";
    }