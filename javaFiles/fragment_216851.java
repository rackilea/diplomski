/**
 * Specify a value SpEL expression for the uri template variable.
 * @param variable the uri template variable.
 * @param expression the expression to evaluate value for te uri template variable.
 * @return the current Spec.
 * @see AbstractHttpRequestExecutingMessageHandler#setUriVariableExpressions(Map)
 */
public S uriVariable(String variable, String expression) {