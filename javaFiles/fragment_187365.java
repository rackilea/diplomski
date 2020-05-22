try {
    // open the file for reading
    InputStream instream = openFileInput("test.txt");


// if file the available for reading
if (instream) {
  // prepare the file for reading
  InputStreamReader inputreader = new InputStreamReader(instream);
  BufferedReader buffreader = new BufferedReader(inputreader);

  String line;

  // read every line of the file into the line-variable, on line at the time
  while (( line = buffreader.readLine())) {
    // do something with the settings from the file
  }

}

// close the file again      
instream.close();
  } catch (java.io.FileNotFoundException e) {
    // do something if the myfilename.txt does not exits
  }