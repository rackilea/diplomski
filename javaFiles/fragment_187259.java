@ControllerAdvice
public class UserRoleAdvice {

    // ... autowire needed services

    @ModelAttribute("currentRole")
    public String currentRole() {
        Users user = usersRepository.findOne(1 L);
        if (user != null) {
            return user.getRole().toString();
        } else {
            return "EMPLOYEE";
        }
    }
}