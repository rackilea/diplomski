if(type.equals("A")){
  //iterate through all words except for "end"
  for (int x = 0; x < i; x++){
    //iterate through specific word's characters 
    for(int z=0;z<words[x].length();z++){
      //actually print
      System.out.print(words[x].charAt(z)+ " ");
    }
  }
}