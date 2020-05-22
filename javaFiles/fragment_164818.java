@Service("b")
Class B{

    A a;

    SomeObject c;

    @Autowired
    @Qualifier("a")
    public B(A a){
        this.a = a;
        c = a.getC();
    }
}