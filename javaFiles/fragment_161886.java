boolean found = false; 
for (int val: test) {
    if (number == val) {
        //System.out.println(number + " in array");
       //set the flag if found 
       found=true;
       //stop once you found what you looking for
       break;
    }
}
//check if the flag is set
if(!found)
    System.out.println(number + " is not in array")