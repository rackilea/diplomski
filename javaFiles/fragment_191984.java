@PostMapping("/company")
public CompletableFuture<ResponseEntity<Object>> save(@RequestBody Company company) {

    Company savedCompany = companyRepository.save(company);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedCompany.getId()).toUri();

    ResponseEntity<Object> response = ResponseEntity.created(location).build();
    LOGGER.debug("Reponse Status for POST Request is :: " + response.getStatusCodeValue());
    LOGGER.debug("Reponse Data for POST Request is :: " + response.getHeaders().getLocation().toString());
    return CompletableFuture.completedFuture(response);
}