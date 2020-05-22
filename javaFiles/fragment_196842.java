FileOutputStream fileStream = null;
PrintStream printStream = null;
File file = new File(FILE_NAME);

try
{

  fileStream = new FileOutputStream(file);
  printStream = new PrintStream(fileStream);

  for (int i = 0; i < FLOAT_ARRAY_SIZE; i++)
  {

    printStream.print(FLOAT_DATA[i]);
    printStream.println();

  }

}
catch(Exception e)
{

  e.printStackTrace();

}
finally
{

  if(printStream != null)
  {

    printStream.close();

  }

}