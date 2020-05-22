import javax.validation.constraints.NotNull;

public class RequestParamsModel {

    public RequestParamsModel() {}

    private List<String> param1;
    private String param2;
    private List<String> param3;
    private String param4;
    private String param5;

    @NotNull
    public List<String> getParam1() {
        return param1;
    }
    //  ...
}