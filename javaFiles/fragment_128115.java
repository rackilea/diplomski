public class User {
    private int rank;
    private String name;
    private char[] pass; // ***** Don't store password as a String
    // ?? other fields if needed

    public User(String name, char[] pass) {
        this.name = name;
        this.pass = pass;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    // again, if this were a real-world program, you wouldn't make password accessible
    public char[] getPass() {
        return pass;
    }

    // other User methods would go here

    @Override
    public String toString() {
        return "User [rank=" + rank + ", name=" + name + "]";
    }

    // you'll want to override equals(Object o) and hashCode() here
}