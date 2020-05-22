@GetMapping("/{id}")
    public List<User> getUser(@PathVariable(name="id") int id)
    {
        return Collections.singletonList(
                new User(1,"username")
        );
    }