public class Helper{
    private String name = "New_name";
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
}

public class MainFile{

    Helper myHelper = new Helper();

    public void create_func(){
        String x =  myHelper.getName();
    }
}