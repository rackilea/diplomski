FileReader myFileReader;
myFileReader = new FileReader(//Your file name);
BufferedReader b; 
b = new BufferedReader(myFileReader);//Read the file
//Write a loop to print out the contents
String line;
line = b.readLine();
while (line != null)
{
    System.out.println(line);
    line = b.readLine();
}
b.close();