public class PokedexMemberJava {
    @SerializedName("types")
    Types[] type;
    ...

public class Types {
    @SerializedName("type")
    public Type typeObject;