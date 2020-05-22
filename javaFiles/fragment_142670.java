@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleMathodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.stream().forEach(fieldError -> {
                validationErrors.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
            });

        }
        return new ValidationErrorResponse(validationErrors);
    }