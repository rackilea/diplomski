public static void main(String[] args) {
  String first = "First";
  // Storing the resulting instance and then call again.
  String s1 = first.concat(" Second");
  s1 = s1.concat(" Third.");

  System.out.println(s1);
  // This is method chaining using String class with concat() method.
  String s2 = first.concat(" Second").concat(" Third.");
  System.out.println(s2);  
}