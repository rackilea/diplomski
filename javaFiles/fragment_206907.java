public class MyResponseUnwrapped{

    @JsonUnwrapped
    private GeneralSubResponse subResponse;

    private String respOne;
}

public class MyResponseNewUnwrapped{

    @JsonUnwrapped
    private GeneralSubResponse subResponse;

    private String respNew;
    private String respbBest;
}