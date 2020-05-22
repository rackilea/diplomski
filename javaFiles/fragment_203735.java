private Person person;

public String login() {
    if (isStudent) person = new Student(); // Rather use factory.
    // ...
    if (isLecturer) person = new Lecturer(); // Rather use factory.
    // ...
    person.login();
    // ...
    return "home";
}