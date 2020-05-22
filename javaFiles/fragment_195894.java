@RooJavaBean
@RooToString
@RooJpaEntity(table = "Example")
@RooJson
public class Example {

    private String name = "default";
    public Example(String name){
        this.name = name;
    }
}