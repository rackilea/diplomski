@GetMapping("/test/{id}")
public String test(Model model, @PathVariable("id") long id) {
    //This part represent your serviceRequestRepository.findById(id);
    User requestedUser = new User(id, "User " + id);
    model.addAttribute("requestedUser", requestedUser);

    //List of users represent your serviceRequestTypeRepository.findAll();
    List<User> users = new ArrayList<>();
    users.add(new User(1, "User 1"));
    users.add(new User(2, "User 2"));
    users.add(new User(3, "User 3"));

    model.addAttribute("users", users);

    return "test";
}