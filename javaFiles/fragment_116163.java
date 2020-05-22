public class PeopleHandler 
{
   private List<Person> people;

   @JsonDeserialize(using = PersonDeserializer.class)
   public void setPeople(List<Person> o)
   {
      people = o;
   }

}