public static String toJson(int i, List<User> users) {
    StringBuilder sb = new StringBuilder("{\"").append(i).append("\" : { \"ids\" : [");
    for (User user : users)
        sb.append(user.getId()).append(",");
    sb.setCharAt(sb.length() - 1, ']');
    sb.append(", \"names\" : [\"");
    for (User user : users)
        sb.append(user.getName()).append("\",\"");
    return sb.replace(sb.length() - 2, sb.length(),"] } ,").toString();
}