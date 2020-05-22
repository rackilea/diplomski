// check IOException in method signature
BufferedWriter out = new BufferedWriter(new FileWriter(path));
Iterator it = MapLocation.iterator(); // why capital "M"?
while(it.hasNext()) {
    out.write(it.next());
    out.newLine();
}
out.close();