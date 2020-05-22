// For each line in the file ...
String line;
int sums[5]; //Change to the number of columns
while ((line = reader.readLine()) != null) {
    String tokens[] = line.split("\t");
    for(int i = 0; i < 5; i++)
    {
       sums[i] += Integer.parseInt(tokens[i]);
    }
 }