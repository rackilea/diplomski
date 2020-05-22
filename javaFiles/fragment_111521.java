/**
 * This class is used by JAX-RS to parse to and from JSON. The field
 * names used here (and by extension the getters and setters) should
 * match those used in your JSON.
 */
class InputRequest {
    int jobId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}

@POST
@Path("module")
@Consumes(MediaType.APPLICATION_JSON)
public List<ModuleProcCount> getInput(InputRequest reqPayload) throws IOException {
    int jobId = reqPayload.getJobId();
}