reader.read(charArray, 0, 5);

 // parse the header

 reader.read(charArray, 0, lengthOfInstruction);

 String instruction = new String(charArray, 0, lengthOfInstruction);

 // do stuff with the instruction