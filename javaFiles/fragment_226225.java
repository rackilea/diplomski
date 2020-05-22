@PostMapping("/boxes")
@Timed
public ResponseEntity<Box> createBox(@Valid @RequestBody Box box) throws URISyntaxException {
    log.debug("REST request to save Box : {}", box);
    if (box.getId() != null) {
        throw new BadRequestAlertException("A new box cannot already have an ID", ENTITY_NAME, "idexists");
    }
    Set<BoxInventory> boxinventories  = box.getBoxInventories();
    log.debug("box inventories : " + Arrays.toString(boxinventories.toArray()));
    for (BoxInventory boxInventory : boxinventories) {
        log.debug("adding box inventory : " + boxInventory);
        box.addBoxInventory(boxInventory);
    }
    log.debug("added all box inventories : " + box);
    Box result = boxService.save(box);
    return ResponseEntity.created(new URI("/api/boxes/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
        .body(result);
}