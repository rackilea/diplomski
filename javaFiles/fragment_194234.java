@Component
public class ItemResourceProcessor implements ResourceProcessor<Resource<Item>> {

    private ControllerLinkBuilder baseLink;

    @Override
    public Resource<Item> process(Resource<Item> resource) {
      resource.add(BasicLinkBuilder.linkToCurrentMapping()
            .slash("items")
            .slash(resource.getContent().getId()).withSelfRel());
      return resource;
    }
}