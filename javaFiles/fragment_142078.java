@CrossOrigin
@PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public Map<String, Object> graphql(@RequestBody GraphQLRequest graphQLRequest, HttpServletRequest httpRequest) {
    // em context estamos passando o Request, usamos para fazer as verificacoes de autenticacao com GraphQl 
    ExecutionInput.Builder inputBuilder = ExecutionInput.newExecutionInput()
                .query(graphQLRequest.getQuery())
                .operationName(graphQLRequest.getOperationName())
                .variables(graphQLRequest.getVariables()) //this is the line you were missing
                .context(httpRequest);
    return executionResult.toSpecification();
}