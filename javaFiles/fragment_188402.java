@Controller
public class SomeController {

  private ObjectFactory<BreadCrumbs> breadCrumbsFactory;

  @Autowired
  public SomeController(ObjectFactory<BreadCrumbs> breadCrumbsFactory) {
    this.breadCrumbsFactory = breadCrumbsFactory;
  }

  public void something() {
    BreadCrumbs breadCrumbs = breadCrumbsFactory.getObject(); // this will give you a different instance on each call
  }
}