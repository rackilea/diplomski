FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null && fieldError.contains(TypeMismatchException.class)) {
                TypeMismatchException typeMismatchException = fieldError.unwrap(TypeMismatchException.class);
                ConversionFailedException conversionFailedException = findConversionFailedException(typeMismatchException);
                if (conversionFailedException != null) {
                    Object value = conversionFailedException.getValue();
                    // get the invalid field value
                }
            }