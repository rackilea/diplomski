File file = new File("/home/matthew/Desktop/RobinHood-1.0.epub");
Locale l = new Locale("es");
Locale.setDefault(l);

// Create a stream to hold the output
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream old = System.out;
System.setOut(new PrintStream(baos));

// Do epubcheck stuff...
EpubCheck epubCheck = new EpubCheck(file);
epubCheck.validate();

// Flush and reset output stream
System.out.flush();
System.setOut(old);

System.out.println("Result >> " + baos.toString());