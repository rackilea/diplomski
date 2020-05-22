private static boolean wasPrinted = false;

public static void nameHere(arguments) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    FileWriter fw = new FileWriter(filepath, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
    if (!wasPrinted) {
        pw.println("A , B, C, D, E, F, G, ");
        wasPrinted = true;
    }
    pw.print(dateFormat.format(date));

    if (cond 1) {
        pw.println("Print STmt1");
    } else if (cond 2) {
        pw.println("Print STmt1");

    } else if (cond 3) {
        pw.println("Print STmt1");

    } else {
        pw.println("Print STmt1");
    }

    pw.flush();
    pw.close();
}