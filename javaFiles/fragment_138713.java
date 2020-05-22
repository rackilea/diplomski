public class Tomato extends Vegetable {

    public void announce() {
        if (color.equals("red")) {
           System.out.println("Found a red tomato!");
        }
        else {
            System.out.println("Found a tomato.");
        }
    }
}

public class Cucumber extends Vegetable {

    public void announce() {
        if (weight >= 100) {
           System.out.println("Found a big cucumber!");
        }
        else {
            System.out.println("Found a cucumber.");
        }
    }
}