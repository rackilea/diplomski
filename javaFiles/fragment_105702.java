public class MyForm
{
   private final Person person;
   private final Passport passport;

   public MyForm()
   {
      this.person = new Person();
      this.passport = new Passport();
   }

   public MyForm(Person person, Passport passport)
   {
      this.person = person;
      this.passport = passport;
   }

   // getters & setters
}