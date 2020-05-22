@Component
public class ItemResourceProcessor implements ResourceProcessor<Resource<Item>> {

    private Method method = ReflectionUtils.findMethod(TestController.class, "getOne", Integer.class);

    @Override
    public Resource<Item> process(Resource<Item> resource) {
    resource.add(linkTo(method, resource.getContent().getId()).withSelfRel());
    return resource;
    }
}