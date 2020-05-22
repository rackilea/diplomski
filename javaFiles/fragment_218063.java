public class MyBean implements Serializable{

List<SelectItem> ddl_example_options;
String ddl_example;

public List<SelectItem> getDdl_example_options() {
    return ddl_example_options;
}

public void setDdl_example_options(List<SelectItem> ddl_example_options) {
    this.ddl_example_options = ddl_example_options;
}

public String getDdl_example() {
    return ddl_example;
}

public void setDdl_example(String ddl_example) {
    this.ddl_example = ddl_example;
}

private void setDdl_example(){
    ddl_example_options=new ArrayList<>();
    ddl_example_options.add(new SelectItem("1","Option-1"));
    ddl_example_options.add(new SelectItem("2","Option-2"));
}

@PostConstruct
public void init(){
    setDdl_example();
}
public MyBean() {
}