@Component
class MyApplicationComponent {

  @Resource(name = "myRegion")
  private MyRegion<?, PdxInstance> region;

}