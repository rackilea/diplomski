for (String channel : channels.keySet()) {
    ArrayList<String> members = channels.get(channel);
    if (members.contains(username)) {
        members.remove(username);
    }
}