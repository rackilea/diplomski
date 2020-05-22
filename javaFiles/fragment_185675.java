public static void main(String[] args) throws Exception {
    String query = "IRON_SWORD 1 name:&aMagic_Iron_Sword lore:&5Magic|is|amazing sharpness:10 hide_enchants";

    System.out.println(getNameSplit(query));
    System.out.println(getNameSubstring(query));
    System.out.println(getNameRegex(query));
}

public static String getNameSplit(String query) {
    String[] pieces = query.split(" ");
    for (String piece : pieces) {
        if (piece.startsWith("name")) {
            return piece.split(":")[1];
        }
    }
    return null;
}

public static String getNameSubstring(String query) {
    int nameIndex = query.indexOf("name:");
    int spaceIndexAfterName = query.indexOf(" ", nameIndex);
    // +5 to skip name:
    return query.substring(nameIndex + 5, spaceIndexAfterName);
}

public static String getNameRegex(String query) {
    Matcher matcher = Pattern.compile("name:(\\S*) ").matcher(query);
    if (matcher.find()) {
        return matcher.group(1);
    }
    return null;
}