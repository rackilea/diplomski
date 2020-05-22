@RequestMapping(method = RequestMethod.GET, value = "/explorer/file/{id:.+}", produces = "application/pdf")
@ResponseBody
public ResponseEntity<?> getFile(@PathVariable Integer id) {
    String filename = explorerService.getById(id).getPath();
    try {
        return ResponseEntity.ok(resourceLoader.getResource("file:" + filename));
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}