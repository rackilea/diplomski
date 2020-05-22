public File createFile(URL url) throws IOException {

    File f = new File("C:\\Users\\my-user\\Desktop\\target.xml");

    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

    OutputStream outStream = new FileOutputStream(f);
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
        outStream.write(inputLine.getBytes());
    }

    outStream.close();
    in.close();

    return f;
}