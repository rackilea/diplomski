public ResponseEntity<EmployeeBankAccountOutputDto> createBankAccount(@ApiParam("Account data") @RequestBody final EmployeeBankAccountInputDto accountCreationDto) {

    try {
        return  ResponseEntity.ok(service.createBankAccount(accountCreationDto));
    } catch (InvalidAccountDataException ex) {
      log.warn(ex.getMessage());
      return ResponseEntity.badRequest();
    } 
}