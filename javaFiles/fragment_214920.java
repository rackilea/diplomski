try {
  FileOutputStream os = new FileOutputStream(FILENAME);
  while( true ){
     os.write(0);
     Thread.sleep(2000);  // wait 2 seconds before the next write
  }
}
catch( FileNotFoundException e ){
  System.err.println("watchdog error: " + e.getMessage())
  System.exit(1);
}