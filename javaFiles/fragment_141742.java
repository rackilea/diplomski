public class Foo {

     public interface JsonOnly{}
     public interface CsvView{}

     @JsonView(JsonOnly.class) 
     private Integer secretNotForCsv;

     // ...

}

@RestController
public class FooController {

       @RequestMapping(...)
       @JsonView(Foo.JsonOnly.class)
       public Foo getJson() {
           // ...
       }

       @RequestMapping(...)
       @JsonView(Foo.CsvView.class)
       public Foo getCsv() {
           // ...
       }
}