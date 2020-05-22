public static void clearCsv() throws Exception {
        FileWriter fw = new FileWriter("output/out.csv", false); 
        PrintWriter pw = new PrintWriter(fw, false);
        pw.flush();
        pw.close();
        fw.close();
    }