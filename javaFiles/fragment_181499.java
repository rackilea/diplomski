@Component
public class Singleton {

  private Foo foo;
  private Bar bar;
  private Any any;

  // inject dependencies 
  @Autowired
  // annotation not required in recent Spring versions
  public Singleton (Foo foo, Bar bar, Any any){
     this.foo = foo;
     this.bar = bar;
     this.any = any;
  }

  public Singleton getInstance() {
      return this;
  }
}