public class Person {
   public final String name;
   public final Address address;

   public Person(String name, Address address) {
       this.name = name;
       this.address = address;
   }
}

//Someplace else
Person peter = new Person("peter", new Address("Dolphin Cove 993", "Stamford", "CT");
peter.address.state = "CA"