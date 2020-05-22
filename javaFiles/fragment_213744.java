@RequestMapping(method = RequestMethod.POST)
public @ResponseBody PersistentEntityResource post(@RequestBody MyEntity entity,
    PersistentEntityResourceAssembler resourceAssembler)) {
  String createdId = commands.sendAndWait(new MyCreateCommand(entity));
  return resourceAssembler.toResource(repo.findOne(createdId));
}