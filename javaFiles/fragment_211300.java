/**
 * PUT  /myEntitys -> Updates an existing myEntity.
 */
@RequestMapping(value = "/myEntitys",
    method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Timed
public ResponseEntity<MyEntity> update(@RequestBody MyEntity myEntityReceived) throws URISyntaxException {
    log.debug("REST request to update MyEntity : {}", myEntityReceived);
    if (myEntityReceived.getId() == null) {
        return create(myEntityReceived);
    }
    MyEntity myEntity = myEntityRepository.findOne(myEntityReceived.getId());
    myEntity.setTitle(myEntityReceived.getTitle());
    MyEntity result = myEntityRepository.save(myEntity);
    return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("myEntity", myEntity.getId().toString()))
            .body(result);
}