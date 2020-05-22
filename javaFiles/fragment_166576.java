int lineCount = 0;
int wordCount = 0;
int charCount = 0;
while (input.hasNextLine()) {
  // read a line from the input file
  String line = input.nextLine();

  // increment line count
  lineCount++;

  // split line into words and increment word count
  String str [] = line.split((" "));
  for ( int i = 0; i <str.length ; i ++) {
    if (str [i].length() > 0) {
      wordCount ++; 
    }
  }

  // increment char count
  charCount += (line.length());
}