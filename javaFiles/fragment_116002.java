@Singleton
@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

@Override
public Response toResponse(ConstraintViolationException e) {
    // There can be multiple constraint Violations
    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    List<String> messages = new ArrayList<>();
    for (ConstraintViolation<?> violation : violations) {
        messages.add(violation.getMessage());

    }
    return Response.status(Status.BAD_REQUEST).entity(StringUtils.join(messages,";")).build();
}

}