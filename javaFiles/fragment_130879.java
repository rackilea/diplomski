@RequestMapping(value = "/all", method = RequestMethod.GET)
public ResponseEntity<?> getAll() {
    List<Transferencia> list = transferenciaDAO.getAll();
    if (!list.isEmpty()) {
        return new ResponseEntity<>(list, HttpStatus.OK);
    } else {//here you can return any type of object doing your respective control of field.
        JsonResponse msj = new JsonResponse("Error", "List empty");
        return new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
    }
}