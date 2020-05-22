@PostMapping("customer/save")
@ApiOperation("Adds customer")
public ResponseEntity<CustomerDto> saveCustomer(
        @ApiParam("Customers to save") @RequestBody @Valid CustomerDti customerDto) {

  return ResponseEntity.ok(customerService.saveCustomer(customerDto);
}