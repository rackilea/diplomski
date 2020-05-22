@GetMapping("/{key}")
public ResponseEntity<Thing> getThing(final @PathVariable String key) {
    final Thing theThing = this.thingService.get(key);

    final ResponseEntity<?> response;
    if (theThing.someProperty()) {
         response = ResponseEntity.ok(theThing);
    } else {
         response = ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    return response;
}