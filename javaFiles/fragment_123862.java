// read all lines in the file into a list
List<String> lines = Files.readAllLines(Paths.get("filename"), Charset.defaultCharset());

// determine the length of the arrays based on the first line
int length = Integer.parseInt(lines.remove(0));    

// first column
String[] col1 = new String[length];

// second column
int [] col2 = new int[length];

// now for every remaining row, add to each column
for(int i = 0; i < length; i++){
   String [] pair = lines.remove(0).split(" ");
   col1[i] = pair[0];
   col2[i] = Integer.parseInt(pair[1]);
}