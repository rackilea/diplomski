for(int i=0; i<marksArray.length; i++)
{
  while (true) {
    System.out.println("Enter marks for subject " + (i+1));
    try
    {
        marksArray[i] = Integer.parseInt(br.readLine().trim());
        break;
    }
    catch(NumberFormatException e)
    {
        System.out.println("Please enter a whole number.");
    }
  }
}