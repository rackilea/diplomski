class Candidate {
    String name; // or whatever is is really is your class
    String party; // same as abover
    ...
    public boolean equals(Object other) {
        if (! (other instanceof Candidate)) {
            return false;
        }
        return name.equals(((Candidate) other).name);
    }
    public int hash() {
        return name.hash();
    }
}