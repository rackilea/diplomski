public static void generateCSV(PrintWriter pw, double[][] ProtonTracking,int n) throws IOException{
    pw.print(String.format("Trial Number :, %d\n",  n));
    for(int i= 0; i < Array.getLength(ProtonTracking); i++) {
        pw.print(String.format("%f, %f%n", ProtonTracking[i][0], ProtonTracking[i][1]));
    }
    pw.flush();
    // <- note that .close() was removed! don't close until completely done.
}