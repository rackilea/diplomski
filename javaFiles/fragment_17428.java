public class User {
    private String name;
    private String address;
    private String hp;

    public User (String name, String address, String hp) {
        this.name = name;
        this.address = address;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return name + " : " + address + " : " + hp;
    }

    public static User userFromInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter customer name: ");
            String name = br.readLine();
            System.out.print("Enter customer address: ");
            String address = br.readLine();
            System.out.print("Enter customer contact no: ");
            String hp = br.readLine();

            return new User(name, address, hp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}