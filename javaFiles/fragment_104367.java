public static void readOffsets()
{
    try {
        File file = new File("indexFile.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("indexFile2.txt");
        PrintWriter pw = new PrintWriter(fw);

        String line;
        int offset = 0;
        pw.write(offset + "\n");
        while((line = br.readLine()) != null)
        {
            int length = line.length();
            offset += length + 1;
            pw.write(offset + "\n");

        }
        pw.close();
        br.close();
    }
    catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
}