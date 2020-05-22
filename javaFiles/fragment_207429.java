String input ="001";//your user input
    /**
     * your check here if input is a  number
     */
    int len=input.length();
    int inputInteger=Integer.parseInt(input);
    inputInteger+=1;

    String output=String.format("%0"+len+"d", inputInteger); 
    System.out.println(output);