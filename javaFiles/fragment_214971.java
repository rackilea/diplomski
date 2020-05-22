String fileName = "TemperatureData.txt";
Scanner inputStream = null;
System.out.println("The file " + fileName + "\ncontains the following lines:\n");
try
{
  inputStream = new Scanner(new File("C:\\Users\\username\\Documents\\TemperatureData.txt"));//The txt file is being read correctly.
}
catch(FileNotFoundException e)
{
  System.out.println("Error opening the file " + fileName);
  System.exit(0);
}

for (int row = 0; row < 4; row++) {
  for (int column = 0; column < 7; column++) {
    String line = inputStream.nextLine();
    int[][] temperatures = new int[4][7];
    temperatures[row][column] = Integer.parseInt(line);
  }
}
inputStream.close();