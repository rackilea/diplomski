Map<Integer, String> horizontal = new HashMap<>();
Map<Integer, String> vertical = new HashMap<>();
boolean horiz = true;
for(String line: al2){
  if(line.contains(":")) horiz = false;
  else if(line.trim().length() > 0) {
    String[] splitted = line.split(" ");
    if(horiz) horizontal.put(Integer.valueOf(splitted[0]), splitted[1]);
    else vertical.put(Integer.valueOf(splitted[0]), splitted[1]);
  }
}