Result dest = new StreamResult(out);
out.close();

OR

OutputStream fileOutputStream = new FileOutputStream("notepad.txt");
Result dest = new StreamResult(fileOutputStream);
fileOutputStream.close();