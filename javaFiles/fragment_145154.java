List<String> linesAsList = new ArrayList<String>();
String line=null;
while(null!=(line=reader.readLine())) linesAsList.add(line);

Collections.sort(linesAsList, new Comparator<String>() {
  public int compare(String o1,String o2){
    return (o1.substring(18,23)+o1.substring(0,1)).compareTo(o2.substring(18,23)+o2.substring(0,1));
  }});

for (String line:linesAsList) System.out.println(line); // or whatever output stream you want