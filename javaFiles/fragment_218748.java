@Path("all")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Patient getAllPatients(){
    Patient x = new Patient();
    x.setNaam("david");
    return x;
}