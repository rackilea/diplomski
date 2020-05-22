StringBuilder data = new StringBuilder();
BufferedReader br = null;
try {
    br = new BufferedReader(new InputStreamReader(yourInputStream));
    String line = "";
    while ( (line = br.readLine()) != null) {
        //do your processing here...
        data.append(line);
    }
} catch (...) {
    //handle exceptions...
} finally {
    if (br != null) {
        br.close();
    }
}
//the whole String content from the response is concatenated and stored in `data`
System.out.println(data.toString());