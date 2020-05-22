@Override
public Resource<ResumeEntity> process(Resource<ResumeEntity> resource) {
if (resource.getLinks().isEmpty()) { 
return resource; 
}
    UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/entities/search/findEntities")
            .buildAndExpand(Long.toString(resource.getContent().getId()));
    resource.add(new Link(uriComponents.toUriString(), "findEntities"));

    return resource;
}