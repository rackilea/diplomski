get("/throwexception", (request, response) -> {
    throw new NotFoundException();
});

exception(NotFoundException.class, (e, request, response) -> {
    response.status(404);
    response.body("Resource not found");
});