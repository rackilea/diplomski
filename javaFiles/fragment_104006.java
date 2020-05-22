@Service("foo")
@Path("/foo")
public class FooClass implements ModuleInterface {
public Response getSomething(@Valid Request obj){
// code
}
}
--

@Service("foov2")
@Path("/new/foo")
public class FooV2Class implements moduleInterface {
public Response getSomething(@Valid Request obj){
// code
}
}

@Component
public class Service {
@Autowired
@Qualifier("foo")
ModuleInterface moduleInterface
}