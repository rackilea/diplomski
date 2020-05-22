int counter = 0;
boolean countLines = false;
while ((line = br.readLine()) != null) {
  // test for TTL line
  if (line.startsWith("CREATE TTL:NAME=")) { 
    countLines = (line.contains("BLQ=TRUE") && line.contains("NAND:TRUE"))
  // if TTL told us to count and it's a GPL line
  } else if(countLines && line.startsWith("CREATE GPL"))  {
    counter++;
  }
}