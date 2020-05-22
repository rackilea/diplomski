public static ArrayList<String> getFileEndingTime() {   
    ArrayList<String> Lines = new ArrayList<String>();
    String file = "tra.srt";
    BufferedReader br = null;

    try {
        br = new BufferedReader(new FileReader(file));
        String line;
        int i = 0;
        while((line = br.readLine()) != null) {
            if (line.indexOf(':') != -1 && line.indexOf(',') != -1 && line.indexOf('0') != -1) { 
                Lines.add(line.substring(18, 29));
                System.out.println(Lines.get(i++));         
            }
        }
    }
    catch(IOException ex) {
        System.err.println(ex);
    }

    return Lines;
}