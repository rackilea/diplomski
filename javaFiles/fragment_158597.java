public class MyObject extends RealmObject {

    @PrimaryKey
    private long databaseId; 

    @SerializedName("id")
    private String MyObjectId;
    ...
    (some more irrelevant fields, constructors, getters and setters)
}