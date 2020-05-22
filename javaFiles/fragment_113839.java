public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    public Response toResponse(ConstraintViolationException exception) {

        final StringBuilder strBuilder = new StringBuilder();

        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            strBuilder.append(cv.getPropertyPath().toString() + " " + cv.getMessage());
        }

        RestResponse responseEntity = RestResponse.responseCode(ResponseCode.CONSTRAINT_VIOLATION).setResponseMessage(strBuilder.toString()).build();

        return Response.status(Response.Status.BAD_REQUEST).entity(responseEntity).build();
    }
}