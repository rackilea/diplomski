public class MyClass{
    private String name;

    @Autowired
    private MyDAO dao;

    public MyClass(String name){
        // assign only name
    }

    // ...
}