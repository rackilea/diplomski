public class Human {
    private String name;
    private Adress adress;

    public Human() {}
    public Human(String name){
        this.name = name;
    }
    public Human(String name, Adress adress) {
        this.name = name;
        this.adress = adress; // or new Adress(adress)
    }

    public void setAdress (Adress adress) {
        this.adress = adress;
    }
}