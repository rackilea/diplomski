String letters;

if (region == 4){
    letters= "EFGH"; 
}
if (region == 3){
    letters= "EFG"; 
}
else if (region == 2){
    letters= "EF"; 
}
else { 
    System.out.println("You inputed a wrong value, try again...");
}
int N = letters.length();