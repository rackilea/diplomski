// ...
String line = in.nextLine();
String[] tokens = line.split(" ");
int i = 0;
while (i < tokens.length){
    String word = tokens[i];
    if (word.equals("the")) {
        the++;
    }
// ...
    i++;
} // end of the while loop