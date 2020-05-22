public class ReadFoobar {

    @Getter private String foobar;

    public String execute(){
        foobar = getService().loadFoobar();
        return SUCCESS;
    }

}