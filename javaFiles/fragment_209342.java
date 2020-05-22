@POST
public Response perform(Request request){
    //TODO attach the request to an asynch background job

    //pseudo code!
    return Response.status(ACCEPTED)
                   .location(/* URI where the result will be accessible*/) 
                   .build();
}