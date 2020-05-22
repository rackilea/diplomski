// Check out if exception occurred
Exception exception = (Exception)request.getAttribute(Globals.EXCEPTION_KEY);
if (exception != null){
  ActionForward forward = processException(request, response, exception, form, mapping);
  processForwardConfig(request, response, forward);
  return;
}