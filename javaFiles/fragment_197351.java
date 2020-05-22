public static void main(String[] args) {
    String s = "Home scored 50 for 8 wickets and guest scored 60 for 5 wickets and batting.";
    String result = "";
    int homeScored = s.indexOf("scored");
    int guestScored = s.lastIndexOf("scored");
    int homeWicket = s.indexOf("for");
    int guestWicket = s.lastIndexOf("for");

    result = "home =" + s.substring(homeScored + 6, homeWicket)
            + "wicket ="
            + s.substring(homeWicket + 3, s.indexOf("wickets")) + "\n"
            + "guest = " + s.substring(guestScored + 6, guestWicket)
            + "wicket ="
            + s.substring(guestWicket + 3, s.lastIndexOf("wickets"))
            + "(batting)";
    System.out.println(result);
}