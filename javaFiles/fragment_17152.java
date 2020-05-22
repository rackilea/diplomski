BufferedReader in = new BufferedReader(new FileReader(file));

while (in.ready()) {

  String s = in.readLine();

  //1% chance to trigger, if it is never triggered by chance you will display the last line
  if (((int)(Math.random*100)) == 50) 
     break;

}
in.close();
System.out.println(s);