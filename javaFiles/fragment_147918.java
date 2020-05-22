@JsonIgnoreProperties(ignoreUnknown = true)
public class YourClass {

@JsonProperty("wrapper")
public Wrapper wrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public static class Wrapper{
        @JsonProperty("Items")
        public ArrayList<Item> items = new ArrayList<Item>();
}


@JsonIgnoreProperties(ignoreUnknown = true)
public static class Item{
        @JsonProperty("name")
        public String name;
        ...
}

....