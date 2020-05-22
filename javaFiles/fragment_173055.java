// open input with Detector stream
// we use BufferedReader so we could read lines
InputStream is = new FileInputStream("in.txt");
AutoDetectInputStream detector = new AutoDetectInputStream(is);
Charset charset = detector.getCharset();
// here we can use the charset to decode the bytes into characters
BufferedReader rdr = new BufferedReader(new InputStreamReader(detector, charset));

// open output to write to
OutputStream os = new FileOutputStream("out.txt");
Writer utf8Writer = new OutputStreamWriter(os, Charset.forName("UTF-8"));

// copy the whole file
String line;
while((line = rdr.readLine()) != null) {
    utf8Writer.append(line);
}

// close streams        
rdr.close();
utf8Writer.flush();
utf8Writer.close();