public class Creator {

    protected String name;

    protected HashMap<String, String> publisher = new HashMap<String, String>();

    public Creator(String name){
            publisher.put("name", name);
    }
}