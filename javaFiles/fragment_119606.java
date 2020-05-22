do{ 
   System.out.print("Please enter an integer or -1 to stop: ");
   input=Integer.parseInt(scan.nextLine());
   boolean flag = true;
   for(int i=0; i<A.length; i++){ 
      if(A[i].equals(input)) {
          System.out.println("Duplicate input. Please enter another value: ");
          flag = false;
          break;
      }
   }
   if(!flag) {
      continue;
   }
   if(input != -1) //if input is 
   Display.userInput(input);
}

while(input != -1);