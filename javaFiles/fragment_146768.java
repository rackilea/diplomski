public class Ingredient {
    String name;
    String subName;
    int status;
    int admin;

    public Ingredient(String name, String subName, String status, String admin) {
        this.name = name;
        this.subName = subName;
        this.status = Integer.valueOf(status);
        this.admin = Integer.valueOf(admin);
    }

    public String getName() {
        return name;
    }
    public int getAdmin() {
        return admin;
    }
    //more get and set methods here. I have only included what is needed for my answer
}