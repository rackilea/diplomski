public class TestFood {

    public static void main(String[] args) {
        //Add fruit to the favFruit array to test addFruit method
        Food.addFruit("Orange");
        //Print the array to prove the array has changed
        System.out.println(Food.makeSentence());
        //Remove fruit from the favFruit array to test the removeFruit method
        Food.removeFruit("Orange");
        //Print the array to prove the array has changed
        System.out.println(Food.makeSentence());

        //Repeat last steps to test for multiple fruit
        Food.addFruit("Banana");
        Food.addFruit("Apple");
        Food.addFruit("Pear");
        Food.addFruit("Orange");
        System.out.println(Food.makeSentence());
        Food.removeFruit("Apple");
        System.out.println(Food.makeSentence());
    }
}

public class Food {

    static final int MAX_SIZE = 10;
    public static String[] favFruit = new String[MAX_SIZE];


    /**
     * Add's a fruit, if and only if there is a space for it.
     *
     * @param fruit Name of the fruit to be added.
     */
    public static void addFruit(String fruit) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (favFruit[i] == null) {
                favFruit[i] = fruit;
                break;
            }
        }
    }


    /**
     * Removes the specified fruit, if it does exist in the food.
     *
     * @param fruit Name of the fruit to be removed.
     */
    public static void removeFruit(String fruit) {
        for (int i = 0; i < MAX_SIZE; i++) {
            //Note the use of the 'equals' method
            if (fruit.equals(favFruit[i])) {
                favFruit[i] = null;
                break;
            }
        }
    }

    /**
     * Computes the used length of the array in this class.
     *
     * @return The length, or count of elements, used in this class.
     */
    public static int realLength() {
        int length = 0;
        for (int i = 0; i < MAX_SIZE; i++)
            if (favFruit[i] != null)
                length++;
        return length;
    }


    public static String makeSentence() {
        //Get the real length of the array
        int length = realLength();
        //Have a variable, used to tell how many more fruits are to be added.
        int fruitsToAdd = length;

        /*
        The purpose of having the two variables will be seen later. But basically
        the purpose is because of the appending of the word "and". If the real
        length of the array is 1, the fruitsToAdd variable will be 1 too. When this
        happens the word "and" will be appended even though there was only one fruit
        in the first place.
         */

        if (fruitsToAdd == 0)
            return "There are no favourite fruits.";

        //Make a StringBuilder to append everything to
        StringBuilder builder = new StringBuilder();

        //Append the start of the sentence to the StringBuilder, depending on how many elements there are
        if (length == 1)
            builder.append("The favourite fruit is: ");
        else
            builder.append("The favourite fruits are: ");

        //Go through all the elements in the array
        for (int position = 0; position < favFruit.length; position++) {

            //Test if the current position of the favourite fruits is not null
            if (favFruit[position] != null) {

                //If this is the last fruit to add, append it with "and [fruitName]."
                if (fruitsToAdd == 1)
                    //If the length was 1, no need to append "and"
                    if (length == 1)
                        builder.append(favFruit[position]).append(".");
                    else
                        //If there are more than 1 fruit, then append "and". Not you could easily make this one expression with a ternary statement
                        builder.append(" and ").append(favFruit[position]).append(".");
                    //Else, append the name of the fruit.
                else
                    builder.append(favFruit[position]);

                //If this is not the second last fruit (but is not the last element either), append a comma and a space for seperation.
                if (fruitsToAdd > 2)
                    builder.append(", ");

                //Decrement the amount of fruits to add.
                fruitsToAdd--;
            }
        }

        //Returns the String contents of the builder
        return builder.toString();
    }
}