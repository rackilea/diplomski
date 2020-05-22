public static String getStringRepresentation(List<String> list) {
    StringBuilder sb = new StringBuilder();
    sb.append(" "); // remove this if you do not want two spaces at the front of the returned string
    for (int i = 0; i < list.size(); i++) {
        sb.append(" " + list.get(i).toString());
    }
    return sb.toString();
}