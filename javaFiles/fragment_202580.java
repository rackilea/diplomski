Scanner in = new Scanner(System.in);

// Loop until they enter either yes or no.
while(true){
String line = in.nextLine();
    // Use this to check if it is yes or no
    if(line.equalsIgnoreCase("yes")){
      // Process yes
      break;
    }else if(line.equalsIgnoreCase("no")){
      // Process no
      break;
    }else{
      // Tell them to enter yes or no since they entered something else.
    }
}