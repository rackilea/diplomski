String temp ="";
// read every char in the input String
for(char c: input.toCharArray()){
   // if it's a digit
   if(Character.isDigit(c)){
       temp +=c; // append it
   }
   else{ // at the end parse the temp String
        data = Integer.parseInt(temp);
        opr = c;
        break;
   }
}

//test
System.out.println("Input: " + input 
                    + "\t Data: " + data
                    + "\t Opr: " + opr);