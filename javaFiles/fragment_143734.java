public static void stateOfWater() {     

System.out.println("Enter a temperature followed by a space and C / F: ");
String userInput = input.nextLine(); // this will read the complete line including spaces.
String celOrFar = userInput.substring(userInput.length()-1);

String degreeString = userInput.trim();
degreeString = degreeString.replace("C", "");
degreeString = degreeString.replace("F", "");
degreeString = degreeString.replace("f", "");
degreeString = degreeString.replace("c", "");

int degree = Integer.parseInt(degreeString);    

if (celOrFar.equals("C")|| celOrFar.equals("c")) {          
    if (degree <= 0) {System.out.println("Your water is a solid at " +userInput);}          
    if (degree >= 100) {System.out.println("Your water is a gas at " +userInput);}      
    if (degree >0 && degree <100) {System.out.println("Your water is a liquid at " +userInput);}            
}

if (celOrFar.equals("F") || celOrFar.equals("f")) {         
    if (degree <= 32) {System.out.println("Your water is a solid at " +userInput);}         
    if (degree >= 212) {System.out.println("Your water is a gas at " +userInput);}          
    if (degree >32 && degree <212) {System.out.println("Your water is a liquid at " +userInput);}           
   }   
}