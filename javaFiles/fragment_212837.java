@RequestMapping(value = "search/within", method = RequestMethod.POST)
@ResponseBody 
public HttpEntity<PagedResources<MyEntity>> 
    within(@RequestBody GeoJsonBody body,Pageable pageable, 
           PagedResourcesAssembler assembler) {
    //  GET PAGE
    Page<MyEntity> page = callToSomeMethod(pageable);

    return new ResponseEntity<>(assembler.toResource(page), HttpStatus.OK);
}