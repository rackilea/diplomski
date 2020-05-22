// do stuff 
// here e.getMessage() can be custom failure message too
response = Response.serverError().entity(e.getMessage()).build();

// return response object
return response;