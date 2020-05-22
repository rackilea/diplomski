String line = s.nextLine();
String[] bits = line.split(" ", 2);
String name = bits[0];
String[] dateBits = bits[1].split("-", 3);
int year = Integer.parseInt(dateBits[0]);
int month = Integer.parseInt(dateBits[1]);
int day = Integer.parseInt(dateBits[2]);

list.add(new DatePeople(name, year, month, day));