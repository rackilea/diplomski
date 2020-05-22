while(!text.equals("stop"))
{
  System.out.print("Insert the number of items, holder value and passing value:");
  text = input.nextLine();

  if (text.equalsIgnoreCase ("stop")) break;

  String arr [] = text.split (" ");
  int items = Integer.valueOf (arr[0]);
  int holder = Integer.valueOf (arr[1]);
  int passing =  Integer.valueOf (arr[2]);
  killBot5000 josephus = new killBot5000(items,holder,passing);
  josephus.execute();
}