while ((input = bufferedReader.readLine()) != null)
{
  count ++; // use a counter variable
  if (count >= fromLineNumber && count <= endLineNumber)
    {
       // process
       if(counter == endLineNumber) // break the loop while you reach the endLineNumber
        {
           break;
        }
    }
}