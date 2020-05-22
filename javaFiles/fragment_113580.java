public static void main (String[] args) throws IOException {
    Scanner fileScan;
    String fileName;

    Scanner scan = new Scanner(System.in);

    System.out.print ("Enter the name of the input file: ");
    fileName = scan.nextLine();
    fileScan = new Scanner(new File(fileName));

    while (fileScan.hasNext()) {
        String currLine = fileScan.nextLine();
        String[] parts = currLine.trim().split(",");

        String playerName = "";
        int hits=0, outs=0, walks=0, sacs=0;

        if (parts.length > 0) {
            playerName = parts[0];
        }

        for (int i=1; i < parts.length; ++i) {
            String stat = parts[i].trim();
            if (stat.equals("h")) {
                ++hits;
            }
            else if (stat.equals("o")) {
                ++outs;
            }
            else if (stat.equals("w")) {
                ++walks;
            }
            else if (stat.equals("s")) {
                ++sacs;
            }
        }

        // display aggregated player stats to the console
        System.out.println(playerName + ":");
        System.out.println("hits : "  + hits);
        System.out.println("outs : "  + outs);
        System.out.println("walks : " + walks);
        System.out.println("sacs : "  + sacs);
    }
}