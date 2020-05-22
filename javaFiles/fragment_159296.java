return Optional.ofNullable(obj)
        .map(optObj -> {
            try {
                myService.create(optObj);
                return new ResponseEntity<>("Operation successful", HttpStatus.CREATED);
            } catch (CustomException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        })
        .orElse(new ResponseEntity<>("Operation failed", HttpStatus.BAD_REQUEST));