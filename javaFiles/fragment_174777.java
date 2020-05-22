public static void main(String[] args) throws IOException
    {

          String number = JOptionPane.showInputDialog("Please enter a number: ");
          StringBuffer evenNumbers = new StringBuffer();
          StringBuffer oddNumbers =new StringBuffer();
          StringBuffer numberZero =new StringBuffer();

        for(int i = 0; i < number.length(); i++) {
          int value=Character.getNumericValue(number.charAt(i));
          if(value!=0 && value % 2 == 0) {
              evenNumbers.append(value).append(',');
          } else if(value % 2 != 0) {
              oddNumbers.append(value).append(',');
          } else if (value == 0){
              numberZero.append(value).append(',');
          }
        }

          JOptionPane.showMessageDialog(null, "Even numbers: " + evenNumbers + "\n" + "Odd numbers: " + oddNumbers + "\n" + "Zero's: " + numberZero);


      }