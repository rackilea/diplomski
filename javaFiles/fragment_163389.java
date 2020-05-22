ArrayList<String[]> dataSet = new ArrayList(10000)//number should be a guess at the amount of data
Scanner in = new Scanner(result);
   in.nextLine(); //skip first line
   while(in.hasNextLine()){

      String line = in.nextLine();
      String []dataset = line.split(",");//store values in array
      dataSet.add(dataset);
   }
   txt1.setText(dataSet.get(0)[4]);
   txt2.setText(dataSet.get(1)[4]);
  }