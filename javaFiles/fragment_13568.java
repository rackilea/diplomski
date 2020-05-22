private static void printToFile(char space, char hash, int spaceCount, int hashCount){
    try (PrintWriter outFile = new PrintWriter(new FileWriter("output.txt"))) {
        printToWriter(outFile, space, hash, spaceCount, hashCount);
    } catch(FileNotFoundException e) {
        e.getCause();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void printToScreen(char space, char hash, int spaceCount, int hashCount){
    PrintWriter out = new PrintWriter(System.out);
    printToWriter(out, space, hash, spaceCount, hashCount);
    out.flush(); // Do not close
}

private static void printToWriter(PrintWriter out, char space, char hash, int spaceCount, int hashCount){
    for (int i = 0; i < 8; i++) {
        out.print(marioStepCreator(space, spaceCount));
        out.println(marioStepCreator(hash, hashCount));
        hashCount++;
        spaceCount--;
    }
}