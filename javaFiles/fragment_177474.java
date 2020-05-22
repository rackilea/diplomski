@PostMapping("test")
public ResponseEntity<Object> graphQl(@RequestBody String body){

    ExecutionResult response = graphQlServer.execute(body);

    ExecutionResultImpl responseImpl = (ExecutionResultImpl) response;

    List<GraphQLError> customizedErrors = Lists.newArrayList();
    for (GraphQLError gqlError : responseImpl.getErrors()) {
            //Do your error custmosation here....
            GraphQLError customizedError = gqlError;
            if (gqlError instanceof ValidationError) {
                ValidationError error = (ValidationError) gqlError;
                customizedError = new ValidationError(error.getValidationErrorType(), error.getLocations(),
                        "Customizing some error message blablabla....");
            }
            customizedErrors.add(customizedError);
    }

    Map<String, Object> specResponse = responseImpl.transform(b->b.errors(customizedErrors)).toSpecification();

    return ResponseEntity.ok(specResponse);
}