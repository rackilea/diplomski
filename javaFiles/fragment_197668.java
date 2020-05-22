List<Double> doubleList = new ArrayList<>();
  System.out.println("enter a number :");
  Scanner kb = new Scanner(System.in);    
   while (kb.hasNext() ) {
            double input = kb.nextDouble();
            if(input == 0){
                break;
            }
            doubleList.add(input);
        }

 System.out.println("Max Value Entered : " + Collections.max(doubleList));