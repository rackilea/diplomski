@POST
@Path("/previous-status/{order}")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String getPreviousStepStatus(@PathParam("order") int order, JAXBElement<WorkflowStep> step) {

    ...

    WorkflowStep wfStep = step.getValue();
    return DBAccessor.getPrevStepStatus(wfStep);
}