BufferedWriter bw = null;
BufferedReader br = null;
try {
    String str = destination + "//" + inFile.getName();
    br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "UTF-8"));
    bw = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(new File(str), false), "UTF-8"));

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

} finally {
    try {
        if(bw != null)
            bw.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        if (br != null)
            br.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}