class Player {

   String firstName ;
   String lastName ;
   int age ;

   public Player(String firstName,String lastName, int age) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
   }

   public String toString(){
       return firstName ;
   }
}