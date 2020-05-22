PrintStream out = new PrintStream(new FileOutputStream("OutFile.txt"));
out.println("E-mail yang diterima adalah sebanyak: "+ total);
out.println("Dengan detail: ");
for (String s : map.keySet()) {
    out.println(s + " = " + map.get(s)); // you might want to change the formatting
}
out.close();