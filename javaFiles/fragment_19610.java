@DeleteMapping("/articulos/{id}")
public ResponseEntity<Void> deleteArticulo(@PathVariable Integer id){
    try {
        articulosService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch(Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}