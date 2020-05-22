public interface A{
}

@Component
public class B implements A{
}

@Component
public class C {
  private A a;
@Autowired
  public C(A a){
   this.a = a;  
}
}