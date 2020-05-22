String evenNo[]=evenNumbers.toString().split(",");
      String oddNo[]=oddNumbers.toString().split(",");

      Arrays.sort(evenNo);
      Arrays.sort(oddNo);

      JOptionPane.showMessageDialog(null, "Even numbers: " +  Arrays.toString(evenNo) + "\n" + "Odd numbers: " + Arrays.toString(oddNo) + "\n" + "Zero's: " + Arrays.toString(numberZero.toString().substring(0, 

numberZero.length()-1).split(",")));