@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> createOrder(@RequestBody @Validated(InputChecks.class) Order order)
                throws NoSuchMethodException, SecurityException, MethodArgumentNotValidException {
    // Some processing of the Order goes here
    SpringValidatorAdapter v = new SpringValidatorAdapter(validator);
    BeanPropertyBindingResult errors = new BeanPropertyBindingResult(order, "order");
    v.validate(order, errors, FinalChecks.class);
    if (errors.hasErrors()) {
        throw new MethodArgumentNotValidException(
                new MethodParameter(this.getClass().getDeclaredMethod("createOrder", Order.class), 0),
                errors);
    }
    orders.put(order);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + order.getId()).build().toUri());
    return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
}