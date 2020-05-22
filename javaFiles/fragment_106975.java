public interface A {}

@Component(value="A_dev")
public class ADev implements A {}

@Component(value="A_prod")
public class AProd implements A {}

public class B {
    @Autowired @Qualifier("A") A a;
}