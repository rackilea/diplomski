public class ResponseChildData {
    private String kind;
    private ChildData data; // This could be a Map<String, String>, but then you'd
                            // possibly lose type information. I haven't used GSON 
                            // enough to know if it would balk when it sees that some
                            // values are int and boolean and refuse to deserialize.
                            // Using a specific type here is probably better anyway

    ...
}