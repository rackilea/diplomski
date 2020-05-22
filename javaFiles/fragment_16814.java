int pos;
 int qty;

 // wordArray is an array formed by splitting string with space delimeter
 for(int i = 0; i < wordArray.length - 1; i++){
   // matching whether current word is "Pos" or  "Qty"
   if(wordArray[i].equals("Pos")) {
     // wordArray[i+1] = "v="1""; we are extracting only digit from that word
     pos = Integer.parseInt(wordArray[i+1].replaceAll("[\\D]", ""))
   } else if(wordArray[i].equals("Qty")) {
     qty = Integer.parseInt(wordArray[i+1].replaceAll("[\\D]", ""))
   }       
 }