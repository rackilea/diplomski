@ApiMethod(
  name = "postSomething",
  path = "postSomething/{id}",
  httpMethod = ApiMethod.HttpMethod.POST
)

public void postSomething(@Named("id") Integer id, HttpServletRequest request, HashMap<String,String> data) {
  //Parse each item of data here...
}