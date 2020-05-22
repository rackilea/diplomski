int lineCount = 0;
while ((line = bf.readLine()) != null)
{
    String[] numbers = line.split(" ");
    for ( int i = 0 ; i < 3 ; i++) 
         matrix[lineCount][i] = Double.parseDouble(numbers[i]);

    lineCount++;
}