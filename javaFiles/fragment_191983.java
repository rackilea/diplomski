@Async("webExecutor")
@PostMapping("/company")
public CompletableFuture<ResponseEntity<Object>> save(HttpServletRequest request, @RequestBody Company company) {

    Company savedCompany = companyRepository.save(company);

    URI location = ServletUriComponentsBuilder.fromRequestUri(request).path("/{id}")
                .buildAndExpand(savedOrganization.getId()).toUri();

    ResponseEntity<Object> response = ResponseEntity.created(location).build();
    LOGGER.debug("Reponse Status for POST Request is :: " + response.getStatusCodeValue());
    LOGGER.debug("Reponse Data for POST Request is :: " + response.getHeaders().getLocation().toString());
    return CompletableFuture.completedFuture(response);
}