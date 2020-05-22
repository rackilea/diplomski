public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ApplicationContext();
        PersonService personService = ctx.getPersonService();
        personService.findAll();
    }
}