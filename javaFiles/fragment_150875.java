public int setISBN(int newISBN){       
   if((newISBN>=10000) &&(newISBN<=20000)){
       return ISBN;
   }else{
       System.out.println("Incorrect ISBN"); // print out that it's invalid
       return -1; // should be known that -1 means it's invalid
   }
}