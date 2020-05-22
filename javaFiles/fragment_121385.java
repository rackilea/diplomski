@GET
public String testLambdaContext(@Context ContainerRequestContext containerRequest) {
   Context lambdaContext =
       (Context) containerRequest.getProperty(RequestReader.LAMBDA_CONTEXT_PROPERTY);
   return lambdaContext.getInvokedFunctionArn()
}