@Component
class MyClass {
    MyOtherClass myOtherClass;
    @Autowired
    public MyClass(MyOtherClass myOtherClass){
        this.myOtherClass = myOtherClass;
    }
}

@Component
class MyOtherClass {
    String s;
    public MyOtherClass(@Value("avalue") final String s){
        this.s = s;
    }
}