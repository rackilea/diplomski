@GetMapping
public ResponseEntity<?> getAllTasks(@RequestParam("status") Optional<Integer> status) {
    if(!status.isPresent()) {
        return new ResponseEntity<>(this.taskResource.findAll(), HttpStatus.OK);
    }
    return new ResponseEntity<>(this.tacheResource.getTachesByEtat(status.get()), HttpStatus.OK);
}