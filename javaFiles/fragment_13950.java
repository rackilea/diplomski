@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseBody
public Response handleInvalidRequest(MethodArgumentNotValidException e) {
    CustomObject ce = (CustomObject) e.getBindingResult().getTarget();
    // do something with CustomObject
}