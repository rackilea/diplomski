boolean quit=true;
do {   // no matter what value quit has, we would loop at least once
     mu.display(firstArray);
     mu.pickNum(firstArray);
     mu.display(firstArray);
     System.out.println();

     for (int row = 0; row < firstArray.length; row++) {
        for (int col = 0; col < firstArray[row].length; col++) {
            quit &= !firstArray[row][col].equalsIgnoreCase("X");   // do boolean AND while checking each element if it is something else than "X"
        }
     }
  } while (!quit);  // stop looping when quit is set to true