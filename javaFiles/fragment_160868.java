public class FunctionView {
    String functionName;
    List<SubFunctionView> subfunctions;

    public FunctionView(String functionName, List<SubFunctionView> subfunctions) {
        this.functionName = functionName;
        this.subfunctions = subfunctions;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<SubFunctionView> getSubfunctions() {
        return subfunctions;
    }

    public void setSubfunctions(List<SubFunctionView> subfunctions) {
        this.subfunctions = subfunctions;
    }
}

public class SubFunctionView {
    String subFunctionName;
    Integer value;

    public SubFunctionView(String subFunctionName, Integer value) {
        this.subFunctionName = subFunctionName;
        this.value = value;
    }


    public String getSubFunctionName() {
        return subFunctionName;
    }

    public void setSubFunctionName(String subFunctionName) {
        this.subFunctionName = subFunctionName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}