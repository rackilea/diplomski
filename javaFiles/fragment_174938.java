public String toString() {
    int count = 0;
    StringBuilder sb = new StringBuilder("{\"name\"=" + name + ", \"friends\"=[");
    for (User friend : friends) {
        sb.append(friend.getName());
        if (++count < friends.size()) sb.append(", ");
    }
    sb.append("]}");
    return sb.toString();
}