class User {
 private int debt; // debt in cents
 private string name;

 // getters

 public void makePayment(int cents){
  debt -= cents;
 }
}

class UserRepository {
 public User GetUserByName(string name){
  // Get appropriate user from database
 }
}