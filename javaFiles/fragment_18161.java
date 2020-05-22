// This is your Foo
public class MyObj {
    public String key;

    // Just for clarity
    @Override
    public String toString() {
        return "MyObj{" +
                "key='" + this.key + '\'' +
                '}';
    }
}

// This is the container
public class MyArray {
   // Property is mandatory in this case
   @JsonProperty("objs")
   List<MyObj> objs;
}