@GET
@Path("/{userName}/questions")
public Response getUserQuestions(@PathParam("userName") String userName){               
    UserDAO userDAO = new UserDAO();        
    List<Question> questions = userDAO.getQuestionsByUserName(userName);        
    Gson gson = new GsonBuilder().setExclusionStrategies(new UserQuestionsExclStrat()).create(); //.serializeNulls()
    String json = gson.toJson(questions);
    System.out.println(json); 
    return Response.status(200).entity(json).build();
}