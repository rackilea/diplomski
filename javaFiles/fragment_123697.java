import javax.validation.Valid;
// ...
@PostMapping(value = "/email/credentials", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> emailCredentials(@RequestBody @Valid EmailCredential emailCredential) {
        return emailService.setCredentials(emailCredential);
    }