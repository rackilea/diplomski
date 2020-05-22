employees.stream() //get stream
    .map(e -> {
        if(e.getFirstName().equals("Raj")) {
            e.setEmail(null);
        }
        return e;
    })
    .collect(Collectors.toList());