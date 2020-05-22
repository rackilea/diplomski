String s = "4x+6y+7z";

//list to store constants
List<Double> constantsList = new ArrayList<Double>(); 

//list to store variables 
List<Character> variablesList = new ArrayList<Character>(); 

//loop through length of string         
for(int i =0; i< s.length();i++) {
    if(Character.isDigit(s.charAt(i))) {
        //add constant to the list as Double
        constantsList.add(Double.valueOf(s.charAt(i))); 
    } else if(Character.isAlphabetic(s.charAt(i))) {
        //add variable to the list as double
        variablesList.add(Character.valueOf(s.charAt(i))); 
    }
}

System.out.println(constantsList); 
System.out.println(variablesList);