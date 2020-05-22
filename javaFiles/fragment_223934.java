@GetMapping("/{id}")
public ResponseEntity getCustomerById(@PathVariable("id") Long id) {

    Customer customer = customerDAO.get(id);
    if (customer == null) {
        return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity(customer, HttpStatus.OK);
}