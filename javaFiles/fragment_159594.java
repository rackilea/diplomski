while (line != null) 
{
   String arr[] = line.split(" ", 2);
   command = arr[0];
   message = arr[1];
   line = reader.readLine();
}