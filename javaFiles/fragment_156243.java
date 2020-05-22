class RecordTreatment {
    public static void main(String args[]) throws IOException
    {
        // Open the file
        File file = new File("C:\\Users\\tolen\\Desktop\\test.txt"); 
        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        FileWriter fstreamWrite = new FileWriter("C:\\Users\\tolen\\Desktop\\test1.txt");
        BufferedWriter out = new BufferedWriter(fstreamWrite);

        String strLine;
        int counter=1;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            String tokens[] = strLine.split(",");
            if (tokens.length > 0) {
                String sub_tokens[] = tokens[16].split("\"");
                tokens[16] = String.format("\"{}_{}",sub_tokens[1],counter);
                out.write(String.join(",",tokens));
                out.write("\n");
            }
        }

        out.close();
        br.close();
    }
}