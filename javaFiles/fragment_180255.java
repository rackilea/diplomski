public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter("c:\\new.csv",true));
    BufferedReader br = new BufferedReader(new FileReader("c:\\txt.csv"));
    String splitBy = ",";
    String line = null;
    while((line = br.readLine()) !=null){
        StringBuffer newLine = new StringBuffer();
        String[] b = line.split(splitBy);
        for (int i = 0; i<b.length; i++)
        {
            if(b[i] == null || b[i].trim().isEmpty())
                continue;

            newLine.append(b[i].trim() + ";");
        }
        out.write(newLine.toString());
        out.newLine();
    }
    out.close();
    br.close();
}