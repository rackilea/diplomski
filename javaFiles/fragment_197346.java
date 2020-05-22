@GetMapping("/test")
public ResponseEntity<String> someTest() {
   return ResponseEntity
      .status(421)
      .contentType(MediaType.TEXT_PLAIN)
      .body("go away world");
}