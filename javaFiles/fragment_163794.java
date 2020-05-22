public class ResponseData {
    private String modhash;
    private List<ResponseChildData> children; // I imagine this is where you're having
                                              // some confusion. You can use a list here
                                              // and you should be fine.

    ...
}