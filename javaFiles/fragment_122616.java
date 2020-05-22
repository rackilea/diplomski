BufferedReader read = new BufferedReader(new FileReader("yourTextFile.txt"));
String line = read.readLine();

while(line !=null)
{
     System.out.println(line);
     line=read.readLine();
}
}catch(Exception ex)
{System.out.println(ex.getMessage());}