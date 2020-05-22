// controller
@ResponseBody @RequestMapping("/description")
public Description getDescription(@RequestBody UserStats stats){
    return new Description(stats.getFirstName() + " " + stats.getLastname() + " hates wacky wabbits");
}

// domain / value objects
public class UserStats{
    private String firstName;
    private String lastName;
    // + getters, setters
}
public class Description{
    private String description;
    // + getters, setters, constructor
}