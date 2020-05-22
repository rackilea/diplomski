@Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                 HttpHeaders headers, HttpStatus status, WebRequest request) {
          String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
          List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
          LOGGER.info("Validation error list : "+validationList);
          ApiErrorVO apiErrorVO = new ApiErrorVO(errorMessage);
          apiErrorVO.setErrorList(validationList);
          return new ResponseEntity<>(apiErrorVO, status);
   }