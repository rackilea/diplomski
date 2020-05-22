out: for(r = 0; r < items.length; r++){
  for(int q=0; q<r; q++){
    if(z==items[q].getCode()){
      System.out.println("Item's code exists");
      break out;
    }
  }