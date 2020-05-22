@Override
public Object invoke(MethodInvocation invocation) throws Throwable {
  if (Response.class != invocation.getMethod().getReturnType()) {
    logger.warning(String.format("%s is @Cachable but does not return a Response object", invocation.getMethod()));
    return invocation.proceed();
  }

  Optional<Request> request = getRequest(invocation);
  if (!request.isPresent()) {
    logger.warning(String.format("%s is @Cachable but does not declare a public Request field named \"request\"", invocation.getMethod()));
    return invocation.proceed();
  }

  Object response = super.invoke(invocation);
  EntityTag responseTag = JaxRsUtil.getEntityTag(response);

  Response.ResponseBuilder builder = request.get().evaluatePreconditions(responseTag);
  if (null != builder) {
    logger.finer("Found matching etag: " + responseTag);
    return builder.build();
  } 
  CacheControl cc = new CacheControl();
  cc.setMaxAge(maxAge);
  builder = Response.fromResponse((Response)response).tag(responseTag).cacheControl(cc);
  return builder.build();
}