final String status = Optional.ofNullable(response)
                              .map(Response::getStatus)
                              .orElse(Status.UNAVAILABLE);

if ("rejected".equals(status)) {
    throw new RequestRejectedException("some exception");
}