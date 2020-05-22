@GetMapping(value="/{empId}", produces=MediaType.APPLICATION_JSON_VALUE)    
public ResponseEntity<EmployeeInfoItem> getEmployeeInfo(@PathVariable("empId") Integer empId) {
    try {
        ...
    } catch (Exception e) {
        logger.error( e.getMessage() );
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
    }
}