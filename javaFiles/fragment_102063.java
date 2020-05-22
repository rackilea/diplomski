@Path("/rest/api/v1/tfg")
public class TfgREST {

@GET
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public Response findAll(@QueryParam("state") List<String> state) throws ServletException, IOException {
    TfgDao dao = new TfgDao();
    JsonArrayBuilder array = Json.createArrayBuilder();

    if(state.isEmpty()){
        LinkedList<Projecte> llista = dao.findAll(true); //TRUE because of API

        for(Projecte p : llista){
           array.add(p.getTitol());
        }
    }
    else{
        LinkedList<String> projs;
        for (String s : state){
            projs = dao.findByState(s);
            for (String x : projs){
                array.add(x);
            }
        }
    }

    return Response.ok(array.build()).build();    
}
}