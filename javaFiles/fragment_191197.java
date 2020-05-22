InputStream    fis;
BufferedReader br;
String         line;

fis = new FileInputStream("the_file_name");
br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
while ((line = br.readLine()) != null) {
    // Deal with the line
}

// Done with the file
br.close();
br = null;
fis = null;