@Override
public Status getStatus(Throwable throwable, Resource resource) {
    Status ret = null;
    Throwable cause = throwable.getCause();
    if (cause == null) {
        Status status = super.getStatus(throwable, resource);
        ret = new Status(status, throwable.getMessage());
        log.log(Level.SEVERE, "Unexpected resource exception <" + ret.toString() + "> for throwable of type <" + throwable + "> at resource <" + resource + ">");
    } else if (cause instanceof NotFoundException) {
        ret = new Status(Status.CLIENT_ERROR_NOT_FOUND, cause, resource.getReference().toString());
        log.info("Not found <" + ret.toString() + "> for throwable of type <" + cause + "> at resource <" + resource + ">");
    } else if (cause instanceof ConstraintViolationsException) {
        ConstraintViolationsException e = (ConstraintViolationsException) cause;
        ret = new Status(Status.CLIENT_ERROR_BAD_REQUEST, cause, e.getViolations().iterator().next().getMessage());
        log.log(Level.SEVERE, "Constraint violation <" + e.getViolations().iterator().next().getMessage() + "> at resource <" + resource + ">");
    } else if (cause instanceof BusinessRuleException) {
        ret = new Status(Status.CLIENT_ERROR_BAD_REQUEST, cause, cause.getMessage());
        log.log(Level.SEVERE, "Business rule exception: <" + cause.getMessage() + "> at resource <" + resource + ">");
    } else {
        Status status = super.getStatus(throwable, resource);
        ret = new Status(status, throwable.getMessage());
        log.log(Level.SEVERE, "Unexpected server exception <" + ret.toString() + "> for throwable of type <" + throwable + "> at resource <" + resource + ">");
    }
    return ret;
}

@Override
public Representation getRepresentation(Status status, Request request, Response response) {
    String ret = "";
    if (status.getDescription() != null) {
        ret = status.getDescription();
    } else {
        ret = "unknown error";
    }
    return new StringRepresentation(ret, MediaType.TEXT_PLAIN);
}