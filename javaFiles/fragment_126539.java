public class Human {
    private String name;
    private Adress adress;

    public Human (String name, Adress adress) {
        this.name = name;
        this.adress = new Adress(adress); 
    }
}