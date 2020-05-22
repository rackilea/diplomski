public ResponseEntity<String> newOrder() {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("User-Agent", "updated-Value");

    return ResponseEntity.ok()
      .headers(responseHeaders)
      .body("New order created.");
}