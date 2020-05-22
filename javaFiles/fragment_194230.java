@Component
public class ItemResourceProcessor implements ResourceProcessor<Resource<Item>> {

    @Override
    public Resource<Item> process(Resource<Item> resource) {
        resource.add(linkTo(methodOn(TestController.class).getOne(resource.getContent().getId())).withSelfRel());
        return resource;
    }
}