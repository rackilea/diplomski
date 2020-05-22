try {    
  BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

  log.write("This will be printed on stdout!\n");
  log.flush();
}
catch (Exception e) {
  e.printStackTrace();
}