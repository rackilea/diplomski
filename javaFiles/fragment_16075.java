public abstract class BaseController {

   private final BaseComponent baseComponent;

   protected BaseController(BaseComponent baseComponent){
       this.baseComponent = baseComponent;
   }

   @GetMapping("/something")
   public ResponseEntity<String> getSomething(){
       return new ResponseEntity<String>(baseComponent.getSomething(), HttpStatus.OK);
   }
}

@RestController
@RequestMapping("/foo")
public class FooController extends BaseController{

   @Autowired
   public FooController(@Qualifier("fooComponent") BaseComponent baseComponent) {
      super(baseComponent);
   }
}

@RestController
@RequestMapping("/bar")
public class BarController extends BaseController{

   @Autowired
   public BarController(@Qualifier("barComponent") BaseComponent baseComponent){
       super(baseComponent);
   }
}

@Component
public class BarComponent implements BaseComponent {

   @Override
   public String getSomething() {
       return "bar";
   }
}

@Component
public class FooComponent implements BaseComponent {

   @Override
   public String getSomething() {
     return "foo";
   }
}