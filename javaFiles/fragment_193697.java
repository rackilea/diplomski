public static void main(String[] args) {
     Person p = new Student("John", "Smith", 12345);
     printInfo(p);
 }

 // this method takes the wider Person type as a parameter, though we can send it a narrower type such as Student if we want
 public static void printInfo(Person p) {
     System.out.println("First: " + p.getFirstName());
     System.out.println("Last: " + p.getLastName());
     if (p instanceof Student) {
         System.out.println( (Student)p).getStudentID() );  // we cast p to Student with Narrow Conversion which allows us to call the getStudentID() method; only after ensuring the p is an instance of Student
     }
}