@DeleteMapping("/articulos/", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity deleteArticulo(@RequestParam String id){
    try {
        articulosService.delete(Integer.valueOf(id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch(Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}