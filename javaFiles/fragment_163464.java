import java.util.Random;

public class Test {

    public static void main (String[] args) {

        Random rand = new Random();
        String[] arrayOfName = {"Elephant", "Deer", "Fish", "Crocodile", "Cat", "Dog", "Bird", "Butterfly", "Chicken", "Ant", "Snake", "Lion", "Horse", "Wolf", "Panda", "Swan", "Lobster"};

        // this will give you a random value between 4 (inclusive) and 11 (exclusive, or 10 inclusive)
        int numberOfRandomValues = rand.nextInt(7) + 4;

        String[] newArrayOfName =  new String[numberOfRandomValues];

        for(int  i = 0; i < numberOfRandomValues; i++) {
            // this will give you a random value between 0 (inclusive) and the size of array (inclusive as well) which you can use to add a random element
            int randomPosition = rand.nextInt(arrayOfName.length);
            newArrayOfName[i] = arrayOfName[randomPosition];
            System.out.println(" - Just added " + newArrayOfName[i] + " on position " + i);
        }

    }

}