@RequestMapping(value = "myservice/emails", method = RequestMethod.POST)
public ResponseEntity<String> testValidation(@Valid @RequestBody @Email String email, Errors errors) {
  if (errors.hasErrors()) {
  return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }
    return email;
}