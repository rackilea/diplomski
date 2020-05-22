@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public @ResponseBody ErrorResponse errorHandler(Exception e, HttpServletRequest request) {
    request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE, Collections.singleton(MediaType.APPLICATION_JSON));
    return ErrorResponseBuilder.buildErrorResponse(e);
}