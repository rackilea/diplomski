FileOutputStream fos = new FileOutputStream("test.out");
OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
Writer out = new BufferedWriter(osw);
...
out.write(ch);
...
out.close();