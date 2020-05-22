try
{
 FileWriter writer = new FileWriter("c:\\temp\\MyFile.csv");
 while(result.next())
 {
 for(int i = 0; i < columnSize; i++)
 {
    writer.append(result.getObject(i));
    if(i < columnSize - 1)
       writer.append(',');
 }
 writer.append('\n');
 }
 }
 catch(Exception e)
{
  e.printStackTrace();
}