@PostMapping(value = "/payment/{unique_transaction_id}", 
     consumes = { MediaType.APPLICATION_JSON_VALUE }, 
     produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Object> handleWpfMessage(
                 @PathVariable("unique_transaction_id") String unique_transaction_id,
                 @Valid @RequestBody WpfPaymentsDTO transaction, 
                 BindingResult result, 
                 HttpServletRequest request) throws Exception {