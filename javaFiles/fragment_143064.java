// to be a bit more efficient
String separator = System.getProperty("line.separator");
while (( line = input.readLine()) != null)
{
    if (!(line.startsWith("#") || 
          line.startsWith("*") ||
          line.isEmpty() )) 
    {
        contents.append(line);
        contents.append(separator);
        System.out.println(line);
    }
}