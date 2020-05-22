@DefaultCoder(AvroCoder.class)

public class MyClass implements Serializable {

public long id;
public HashMap<String,HashSet<String>> a;

@SerializedName("a")
public Integer Id;
@SerializedName("ae")
public String ae;
}