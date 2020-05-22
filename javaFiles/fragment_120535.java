@Component
@Scope("request")
public class Foo {
    @Autowired private HttpServletRequest request;

    //
}