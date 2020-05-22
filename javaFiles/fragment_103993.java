public class User {

    public static final int ADJUSTTYPE_ADD = 1;
    public static final int ADJUSTTYPE_REPLACE = 2;
    public static final int ADJUSTTYPE_MULTIPLY = 3;
    public static final int ADJUSTTYPE_DIVIDE = 4;

    String id;
    String userName;
    String email;
    String password;
    int coins;
    int gems;

    public User(String id, String userName, String email, String password) {

        this.id = id;
        this.email = email;
        //And so on. Don't mind this

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return this.coins;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public int getGems() {
        return this.gems;
    }

    public long getLongId() {
        long id;
        try {
            id = Long.valueOf(this.id);
        } catch (Exception e) {
            return -1;
        }
        return id;
    }
}