public staticvoid main (String[] args){
   String name;
   System.out.println("Enter your complete name");
   Scanner input = new Scanner(System.in);
   name = input.nextLine();
   System.out.println("Your name is: "+name);
   name=" "+name;
   //spacebar before string starts to check the initials
   String ini; 
   // we use ini to return the output
   for (int i=0; i<name.length(); i++){
      // sorry about the 3x&&, dont remember the use of trim, but you
      // can check " your name complete" if " y"==true y is what you want
      if (name.charAt(i)==" " && i+1 < name.length() && name.charAt(i+1)!=" "){
         //if i+1==name.length() you will have an indexboundofexception
         //add the initials
         ini+=name.charAt(i+1);
      }
   }
   //after getting "ync" => return "YNC"
   return ini.toUpperCase();
}