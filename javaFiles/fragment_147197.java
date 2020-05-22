public class Dog {
    int weight;

    public void setWeight(int i) {
        if (i > 0) {
            this.weight = i;
        } else {
            System.out.println("A dog can't have negative weight!");
        }
    }
}