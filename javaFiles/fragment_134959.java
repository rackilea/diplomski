private Response buildResponse(Status status, String reason) {
    Response response = new Response();
    response.setStatus(status.getStatus());
    response.setStatusCode(status.getStatusCode());
    response.setResult(status.getResult());

    if (reason != null) {
        response.setReason(reason);
    } else {
        response.setReason(status.getReason());
    }

    return response;
}