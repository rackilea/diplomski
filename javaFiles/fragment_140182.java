@GetMapping
public ResponseEntity<?> getAllTasks() {
   return ResponseEntity.ok().body(this.taskResource.findAll());
}

@GetMapping(params = "status")
public ResponseEntity<?> getAllTasksWithStatus(@RequestParam("status") final int status) {
   return ResponseEntity.ok().body(this.tacheResource.getTachesByEtat(status));
}