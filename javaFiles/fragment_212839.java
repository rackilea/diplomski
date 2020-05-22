Page<MyEntity> page = callToSomeMethod(pageable);

ControllerLinkBuilder ctrlBldr =
    linkTo(methodOn(ShipController.class).within(body, pageable, asm));
UriComponentsBuilder builder = ctrlBldr.toUriComponentsBuilder();

int pageNumber = page.getPageable().getPageNumber();
int pageSize = page.getPageable().getPageSize();
int maxPageSize = 2000;

builder.replaceQueryParam("page", pageNumber);
builder.replaceQueryParam("size", pageSize <= maxPageSize ? 
    page.getPageable().getPageSize() : maxPageSize);

Link selfLink =
    new Link(new UriTemplate(builder.build().toString()), "self");