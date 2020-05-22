@GetMapping("/service-executions")
public ResponseEntity<Page<ServiceExecutionDTO>> getAllServiceExecutions(
    @RequestParam(required = false) MultiValueMap<String, String> parameters,
    @QuerydslPredicate(root = ServiceExecution.class, bindings = ServiceExecutionQueryRepositoryImpl.class) Predicate predicate, 
    Pageable pageable
) {
    Page<ServiceExecutionDTO> page = facade.findAll(parameters, predicate, pageable);
    return new ResponseEntity<>(page, HttpStatus.OK);
}