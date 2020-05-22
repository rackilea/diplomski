@Component(configurationFactory = true, metatype = true, policy = ConfigurationPolicy.REQUIRE, label = "CDN Link Rewriter", description = "Rewrites links to all static files to use configurable CDN")
@Service(value = TransformerFactory.class)
public class StaticLinkTransformerFactory implements TransformerFactory {

//all property declarations as in question
private Map<String, Object> map;
@Activate
void activate(Map<String, Object> map) {
    this.map = map;
}
@Override
public Transformer createTransformer() {
    return new StaticLinkTransformer(map);
}
}