boolean foundAt = false;
for (i=0; i<anyLines.length; i++) {

  // --> Here are a bunch of instructions that replace certain strings - they are the lines after @ symbols <--
  // --> I'm not going to list them ... <--

  if (anyLines[i].startsWith("@")) {
    foundAt = true;
    String theLine = anyLines[i].substring(1);
    Integer theInt = null;
    if (theLine.matches("\\d+")) {
      theInt = Integer.parseInt(theLine);
    }
    else {
      theInt = wordValueMap.get(anyLines[i].substring(1));
    }

    if(theInt!=null) {
      System.out.println(Integer.toBinaryString(theInt));
    }
    else {
      //ERROR
    }
  }
  else if(foundAt) {
    System.out.println(anyLines[i]);
  }
}