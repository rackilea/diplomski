for (int row = 0; row < array.length; row++) {
        for (int column = 0; column < array[row].length; column++) {
             array[row][column] = readValidInputFromUser();   
        }
 }

 public string readValidInputFromUser()
 {
    while(true)
    {
           int number = input.nextInt();
           if(number >= 0) {
              return number;
           } else {
              System.out.println("Input must be > 0.");
           }
    }
 }