@PostMapping(path="/CreateAccount")
public @ResponseBody String CreateUser (@RequestBody User user) {

    if (user == null)
    {
        return "User cannot be blank";
    }

    User u = findByUsername(user.Username);

    // your code...

    return usrToken;
}