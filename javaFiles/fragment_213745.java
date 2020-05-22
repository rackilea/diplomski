@RequestMapping(method = RequestMethod.POST)
public @ResponseBody Resources<PersistentEntityResource> post(
    @RequestBody MyEntity entity,
    PersistentEntityResourceAssembler resourceAssembler)) {
  List<MyEntity> myEntities = ...
  List<> resources = myEntities
      .stream()
      .map(resourceAssembler::toResource)
      .collect(Collectors.toList());
  return new Resources<PersistentEntityResource>(resources);
}