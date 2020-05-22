@GET
@Path("studentID/{studentID}")
@Produces({"application/xml","application/json"})
public List<Exam> getExamsOfStudent(@PathParam("studentID") Integer studentID) {  
  javax.persistence.Query query = getEntityManager().createNamedQuery("Exam.getExamsOfStudent");
  query.setParameter("studentID", studentID);
  return query.getResultList();
}