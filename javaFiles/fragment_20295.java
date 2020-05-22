@Action(value = "testJsonAction",
  results = @Result(type = "json", params = {"enableSMD", "true"}),
  interceptorRefs = @InterceptorRef(value="json", params={"enableSMD", "true"}))
public String executeAction() throws Exception {
  return SUCCESS;
}