int counter = 0;
boolean countLines = false;
while ((line = br.readLine()) != null) {
  if (line.startsWith("CREATE TTL:NAME=") && line.contains("BLQ=TRUE") && line.contains("NAND:TRUE")) {
    countLines = true;
  } else if (line.startsWith("CREATE TTL:NAME=") && !(line.contains("BLQ=TRUE") || line.contains("NAND:TRUE"))){
    countLines = false;
  } else if( line.startsWith("CREATE GPL") && countLines )  {
    counter++;
  }
}