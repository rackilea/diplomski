import com.google.gson.annotations.SerializedName;

class Person {
    boolean success;
    @SerializedName("person-name")
    String personName;
}