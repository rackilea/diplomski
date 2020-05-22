@GET
@Path("getStudents")
public Response getStudents(@Context HttpServletRequest request){

           if (request.getParameterMap().isEmpty()) {
               // return all students in Reponse
           } else {
               String queryParam = request.getQueryString();
               // check queryParam and return on student in Response
           }


    }