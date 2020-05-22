//...
Set<Role> roles = new HashSet<>();
roles.add(roleRepository.findByRoleName("ADMIN").get()); // <- maybe orElse() would be better, but it's just to show the use case

User user = new User(1, "SztyJkmajster", "password", roles);
userRepository.save(user);