@ManagedBean
@ViewScoped
public class TableBean {

    private List<String> items;

    @PostConstruct
    public void init() {        
        items = new ArrayList<String>();
        items.add("bar");
        items.add("kaz");
        items.add("foo");        
    }

    public String doAction(String string) {
        System.out.println(string);
        return "";
    }

    public List<String> getItems() {
        return items;
    }    

}