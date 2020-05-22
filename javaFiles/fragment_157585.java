class MyComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.id, o2.id);
    }
}


public class User {
    public String name;
    public int id;

    User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "<name: " + this.name + ", id: " + this.id + ">";
    }

}



public class Designer extends User{
    Designer(String enter code herename, int id) {
        super(name, id);
    }
}


public class Solution {
    public static void main(String[] args) {
        ...

        ArrayList<User> merged = new ArrayList<User>(designers);
        merged.addAll(users);
        merged.sort(new MyComparator());
...
    }
}