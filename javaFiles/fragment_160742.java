String str = destination + "//" + inFile.getName();
// note the paranthesis here, notfing that this is has to be closed after leaving the try block.
try (
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "UTF-8"));
    BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(new File(str), false), "UTF-8"))) {

    String line;
    try {
        while ((line = br.readLine()) != null) {
            bw.write(line);
            System.out.println(line);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
} catch (FileNotFoundException ex) {
    ex.printStackTrace();

} catch (UnsupportedEncodingException ex) {
    ex.printStackTrace();

} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}