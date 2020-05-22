String[] lines= /*The lines from your file*/;
for(String line:lines){ // For each String `line` in `lines`
 String[] numbers=line.split(" "); // Split `line` before and after " "
 int no1=Integer.parseInt(numbers[0]); // Get the first number (as String) and convert it to an int
 int no2=Integer.parseInt(numbers[1]); // Get the second number (as String) and convert it to an int
}