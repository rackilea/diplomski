Map<User, Employee> userEmployee = userRepo.findAll().stream()
    .map(u -> {
        u.setName(name);
        return u;
    })
    .collect(Collectors.toMap(
      u -> u,
      u -> employeeRepo.findById(u.getId())
    ))