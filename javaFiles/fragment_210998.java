static class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

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

public static void main(String[] args) {//throws Exception {
    List<User> users = new ArrayList<User>();
    users.add(new User(1, "anton"));
    users.add(new User(2, "berta"));
    users.add(new User(3, "charlie"));
    System.out.println(toJson(1, users));
 }