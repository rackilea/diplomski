public static void main (String[] args) { 

  final int DRINKING_AGE = 21;
  final int ADULT = 18;
  final String LEGAL_DRINKING_AGE_MESSAGE = "You are legally able to drink";

  int age = Integer.parseInt(JOptionPane.showInputDialog( "Enter Your Age"));

  boolean ageCheck = age >0 && age <=100;
  //check to see if the age is within range
  if (ageCheck) {
    String gender =  JOptionPane.showInputDialog( "Enter Your Gender (F/M)");
    boolean genderCheck = gender.equalsIgnoreCase("M")  || gender.equalsIgnoreCase("F");
     //check to see if the user entered M or F 
     if (genderCheck) {
           //if we pass both checks, then do the rest of the logic
           JOptionPane.showMessageDialog(null,"OUTPUT:  Your age is " + age + " and Gender is " + gender);

     } else { 
        //Write an error for invalid Gender
        JOptionPane.showMessageDialog(null,"Error:  Gender must be F or M") ;  
     }

  } else {
     //Write an error for invalid Age
     JOptionPane.showMessageDialog(null,"Error: Age must be between 0 -100") ;  

  }
}