Double [][] myMatrix = new Double[3][4];
int counter = 0, rowIndex=0,columnIndex=0;
while(input_file.hasNextLine())
{   counter++;
    if(counter%4 == 0)
    {
        rowIndex++;
        columnIndex=0;
    }
    String line = input_file.nextLine();
    List<String> myList = new ArrayList<String>(Arrays.asList(line.split(",")));
        Double numberdouble =0.0;
        String numberstring = myList.get(column);
        if(isDouble(numberstring))
        {
          numberdouble = Double.parseDouble(numberstring);
        }
        else
        {
          numberdouble=0.0;
        }
        myMatrix[rowIndex][columnIndex++] = number double;
        System.out.println(numberdouble);
}