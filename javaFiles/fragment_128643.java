package com.gs.package.service;

public class ExceptionHandler implements ExceptionMapper<BusinessException> {
    public Response toResponse(BusinessException exception) {

        //you can modify the response here
        Response.Status status;

        status = Response.Status.INTERNAL_SERVER_ERROR;

        return Response.status(status).header("exception", exception.getMessage()).build();
    }
}