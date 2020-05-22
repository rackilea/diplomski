boolean validPassword = true;

for (i=0;i<9;i++) { 
    if (myString.equals(myArray[i])) { 
        System.out.println("Invalid password");
        validPassword = false;
        break;
    } 
} 

if(validPassword) {
    System.out.println("Valid password");
}