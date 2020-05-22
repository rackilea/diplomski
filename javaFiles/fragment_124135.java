FileWriter outFile = new FileWriter("asdf.txt", true);
try {
    PrintWriter out1 = new PrintWriter(outFile);
    try {
        out1.append(username);
        out1.println();
        out1.append("adfdas");
    } finally {
       out1.close();
    }
} finally {
   outFile.close();
}