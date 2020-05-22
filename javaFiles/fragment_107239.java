public static void main(String args[]) throws FileNotFoundException {
    Scanner LyricsFile = new Scanner(new FileReader("C:/Users/xxxx/Desktop/lyrics.txt"));
    ArrayList<String> LyricsList = new ArrayList<String>();
    ArrayList<String> pangngalan = new ArrayList<String>();
    while (LyricsFile.hasNext()) {
        String lyricssArray[] = LyricsFile.nextLine().split(" ");

        for (String str : lyricssArray) {
            LyricsList.add(str.replaceAll(",|\\.", ""));
        }
        String[] pangalanStrArray = {"Gagamba", "Araw", "Sanga", "Ulan"};
        String[] panghalipStrArray = {"sila"};
        String[] pangatnigArray = {"At"};
        String[] pandiwaArray = {"Umakyat", "Itinaboy", "Dumating"};
        String[] pangUriStr = {"palaging", "natuyo", "maliliit", "masaya"};
        String[] pangAbayArray = {};
        String[] pangUkolArray = {};
        String[] pangAwiArray = {};
        String[] pangAngkopArray = {"Na"};
        String[] pantukoyArray = {"Ang"};

        for (String name : LyricsList) {
            for (String compare : pangalanStrArray) {
                if (name.equalsIgnoreCase(compare) && !pangngalan.contains(compare.toLowerCase())) {
                    pangngalan.add(name.toLowerCase());
                    break;
                }
            }
        }
    }
    System.out.println("1.Pangngalan: " + pangngalan);
}