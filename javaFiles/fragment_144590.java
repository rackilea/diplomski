/**
 * Spring ResultHandler for MVC testing, allows the assignment of a JSON path to a variable.
 */
public class AssignmentResultHandler implements ResultHandler {

    private final JsonPath jsonPath;
    private final AssignmentResult assignmentResult;

    public static ResultHandler assignTo(String jsonPath, AssignmentResult assignmentResult) {
        return new AssignmentResultHandler(JsonPath.compile(jsonPath), assignmentResult);
    }

    protected AssignmentResultHandler(JsonPath jsonPath, AssignmentResult assignmentResult) {
        this.jsonPath = jsonPath;
        this.assignmentResult = assignmentResult;
    }

    @Override
    public void handle(MvcResult result) throws Exception {
        String resultString = result.getResponse().getContentAsString();
        assignmentResult.setValue(jsonPath.read(resultString));
    }
}