FileReader fr = null;
BufferdReader br = null;

try {
    fr = new FileRader(file);
    br = new BufferedReader(fr);

    // do something..

} finally {
    if (br != null) br.close();
    if (fr != null) fr.close();
}