Employee employee = repository.findById(id).orElseThrow(
        new Supplier<EmployeeNotFoundException>() {
            @Override
            public EmployeeNotFoundException get() {
                return new EmployeeNotFoundException(id);
            }
        }
    );