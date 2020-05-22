String[] lineArray = line.split(" - ", 2);
String one = lineArray[0];
String two = lineArray[1];
type = new DataType(one, two);
queue.put(type);
log.readMessage(one, two);