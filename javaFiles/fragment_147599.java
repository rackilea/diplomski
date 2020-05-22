public static String printMonth(ArrayList<Entry> uploadResult) throws /*what?*/ {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is the month's name?");
    String month = keyboard.nextLine(); 
    boolean monthPresent = false;
    for (Entry uploadResult : uploadResults) {
        if ( uploadResult.getMonth().equals(month)){
            monthPresent = true;
            System.out.println(uploadResult.getDay() + "--" + uploadResult.getPowerOutput());
        }

        if( !monthPresent ){
            System.out.println("Month info not available");
        }
    }
}