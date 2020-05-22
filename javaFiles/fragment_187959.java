@GET @Path("/my") 
@Produces(MediaType.APPLICATION_JSON) 
public ArrayList<MyProgressResponse> getProgressResponse(){     
// Get the data from DB     
// Here the getDate will give me List<MyProgressResponse>

ArrayList<MyProgressResponse> response=(ArrayList<MyProgressResponse>) getData();

return response; 
}