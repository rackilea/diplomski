@PostMapping(value = "/lookup")
public ResponseEntity<AppResponse> getLookup(@RequestBody Map<String, Object> lookupRequestObject) {

    // THIS METHOD KNOWS WHICH FIELD TO USE
    // FURTHER LOGIC WOULD BE HERE.

    return ResponseEntity.ok(response);
}