try {
        // write code for check url
    } catch (Exception ex) {
        List<String> errors = new ArrayList<>();
        errors.add("Invalid URL...");
        throw new ValidationErrorException(errors);
    }