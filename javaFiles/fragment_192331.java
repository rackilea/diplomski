public class AgentResponse<T> {

    private T result;

    @JsonCreator
    public AgentResponse(@JsonProperty("result") T result) {
        this.result = result;
    }
    public T getResult() {
        return result;
    }
}