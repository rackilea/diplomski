OutputStreamWriter ows = new OutputStreamWriter(new FileOutputStream("a.txt"));
ows.write('a');
ows.close();
FileOutputStream fos = new FileOutputStream("b.txt");
fos.write('b');
fos.close();