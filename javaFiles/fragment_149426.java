while (true) {
  System.out.println("Enter no. of subjects");

  //check if input is integer
  try
  {
      subNo = Integer.parseInt(br.readLine().trim());
      break;
  }
  catch(NumberFormatException e)
  {
    System.out.println("Please enter a whole number.");
    // Nothing required to continue loop.
  }
}