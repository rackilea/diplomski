public static void saveShowStopper() {

    try {
        General.createFile("ShowStopper","tempShowStopper.txt");
    } catch (ParseException e) {
        e.printStackTrace();
    }
}