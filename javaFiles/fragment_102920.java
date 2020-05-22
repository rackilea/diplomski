@PostMapping("/users")
public String register(
    String user, 
    String pw,  
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  @ModelAttribute LocalDate beginning) 
{
    // ...
}