public class Animal implements Comparabe<Animal> {
    private String type;
    private int number;
    public Animal(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public int compareTo(Animal other) {
       //sorting logic here, first sort strings if they equals sort by integers.
    }
}