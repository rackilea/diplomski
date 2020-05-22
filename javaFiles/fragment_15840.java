public static void main (String [] args){ 

    Scanner input = new Scanner(System.in);
    String numberInput = "";

    while(!numberInput.equals("@@") && totalNumbers < MAXTIMESTOLOOP) {

             System.out.print("Enter number " + totalNumbers + ". Type @@ to stop.");
             numberInput = input.next(); 
             /* Add number to numberList */
             if(!numberInput.equals("@@")){
             numberList.add(numberInput);}
             totalNumbers++;

       }
       }