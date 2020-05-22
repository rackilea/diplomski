static class User implements Comparable<User> {
    private final int id;

    public User(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(User usr) {
        return 42; // don't do this
    }

}