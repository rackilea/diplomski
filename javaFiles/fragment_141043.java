if (q == 0) { // We obtained a Blank, add +1 to the counter and store or print to the console the character ' '
   if (countBlank < itemsBlank) {
       System.out.print("' ' "); // Or box[i][j]=' '
       countBlank +=1;
   } else {
       j-=1; // If the quota is reached Blank, subtract 1 from j to try to get other character in that position in the array.   
   }                        
} 
if (q == 1) { // We obtained a 'O'
    if (countO < itemsO) {
       System.out.print("'O' ");
       countO+=1;
    } else {
       j-=1;
    }    
}
if (q == 2) { // We obtained a 'X'
    if (countX < itemsX) {
       System.out.print("'X' ");
       countX+=1;
    } else {
       j-=1;
    }    
}