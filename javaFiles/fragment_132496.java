final class Node {

    @SerializedName("id")
    private final String id = null;

    @SerializedName("name")
    private final String name = null;

    @SerializedName("subdata")
    private final Data subdata = null;

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    Data getSubdata() {
        return subdata;
    }

}