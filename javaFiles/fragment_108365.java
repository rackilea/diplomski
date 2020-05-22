@GET
  @Path("/insertRecord") 
  @Produces(MediaType.APPLICATION_XML))
  public UserMessage someInsertMethod(@QueryParam("id") int id){
  UserMessage uMsg = new UserMessage();
  try{
//try insert here

 }catch(SqlException sqle){

  switch (sqle.getErrorCode()){
  case num1:  //replace num1 with the actual error code
    uMsg.setUserCode(UserMessage.UserCodes.DATA_ALREADY_EXIST);
    uMsg.setUserMsg(" Key already exists");
    break;
  case num2:
  uMsg.setUserCode(UserMessage.UserCodes.DATA_WRONG_FORMAT);
    uMsg.setUserMsg(" Data wrong format");
    break;
  }
  }
return uMsg;
 }