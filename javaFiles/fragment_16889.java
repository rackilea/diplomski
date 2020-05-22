public Datasource<Son> getSonsFromParent( MultivaluedMap<String, String> formParams) {

  String idParent = formParams.getFirst("idparent");

  if(idParent == null || idParent.isEmpty()){
     // return .... [idParent is required] 400 Bad Request
  }
}