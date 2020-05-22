public class GsonTest {
    public static void main(String[] args) throws Exception {
        System.out.println(new Gson().toJson(new Allowed()));
    }    
}

class Allowed {
    @SerializedName("@val")
    private String val = "Hey";
}