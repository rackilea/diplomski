public class User {
    private String name;
    private String age="not set";

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class GsonClient {
    public static void main(String[] args) {
        String usersJson = "[ { \"name\": \"henry\" }, { \"name\": \"justin\",\"age\":null } ]";
        Gson gson = new GsonBuilder().serializeNulls().create();
        User[] usersWithAge = gson.fromJson(usersJson, User[].class);
        for (User user : usersWithAge) {
            System.out.println(user);
        }
    }
}