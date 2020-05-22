public class MyData {
    public String name = "";
    public String nameonly = "";
    public int id = 0;
    public double earn = 0;
    public double paid = 0;

    public MyData(String name, String nameonly, int id) {
        this.name = name;
        this.nameonly = nameonly;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("MyData [name=%s, nameonly=%s, id=%s, earn=%s, paid=%s]", name, nameonly, id, earn, paid);
    }
}