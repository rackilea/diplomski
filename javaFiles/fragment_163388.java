Scanner in = new Scanner(result);
   in.nextLine(); //skip first line
   int count = 0;
   while(in.hasNextLine()){

      String line = in.nextLine();
      String []dataset = line.split(",");//store values in array
      if (count == 0){
          txt1.setText(dataset[4]);//Should be 3 element of first line
      }else if (count ==1){
          txt2.setText(dataset[4]);//Should be 3 element of second line
      }
    count++;
   }
  }