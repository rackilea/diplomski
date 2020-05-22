@Component
public class AViewPreparer implements ViewPreparer {

    @Autowired
    private AutowiredBean autowiredBean;

    @Override
    public void execute(Request tilesRequest, 
        AttributeContext attributeContext) throws PreparerException {
        attributeContext.putAttribute("tilesAttributeName", 
            new Attribute("tilesAttributeValue"));
    }
}