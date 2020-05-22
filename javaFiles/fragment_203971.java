String txt = // the resulting String is stored here
new Scanner( // Create a scanner to read the file
new File( "pathToFile" ) ) // pass a new file to the scanner to read
.useDelimiter("\\Z") // set the delimiter to the end of the file
.next(); // read the scanner until the next delimiter, 
         // in this case it is the end of the file.