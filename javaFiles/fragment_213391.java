boolean finished = false;
while(!finished && reader.hasNext()) {
  final int event = reader.next();
  //set finished = true if you hit an event that means you want to stop parsing
}
//don't forget to close the reader and the I/O streams