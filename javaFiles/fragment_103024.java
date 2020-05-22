public static boolean matchesChoice(String color, String choice){
    String a= color;
    String c = choice;
    if (a.equalsIgnoreCase(c.substring(0,1)) || a.equalsIgnoreCase(c)) {
        return true;
    }
    return false;
}