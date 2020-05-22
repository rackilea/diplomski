ArrayList<String> lines = new ArrayList<String>();
String line;
while ((line = fin.readLine()) != null) {
       lines.add( line );
}

Collections.sort(lines);