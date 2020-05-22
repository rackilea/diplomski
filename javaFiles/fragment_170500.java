public class DeleteValue {

    String fruits[] = { "apple", "orange", "banana", "mango", "Cherries", "Blueberries" }; // array of fruits

    public void delete(String fruitName) {

        // printing array of fruits before deletion
        System.out.println("\nAvailable fruits Before delete : " + fruits.length + "\n");
        for (String s : fruits) {
            System.out.println(s + " is Available\n");
        }

        int length = fruits.length;
        int lengthNew = length;
        int countNull = 0;

        // 1. Find and delete the fruit
        for (int i = 0; i < fruits.length; i++) {

            if (fruits[i] == fruitName) {
                fruits[i] = null;
                break;
            }

        }

        // count the null or deleted values so that we can create a new array of length
        // minus the deleted fruit
        for (int i = 0; i < fruits.length; i++) {

            if (fruits[i] == null) {
                countNull++;

            }

        }

        // new array length
        lengthNew = lengthNew - countNull;

        // create new array of fruits
        String newFruits[] = new String[lengthNew];

        // assigning values from original array to new
        int j = 0;
        for (int i = 0; i < fruits.length; i++) {

            if (fruits[i] == null) {
                continue;

            }
            if (fruits[i] != null) {
                newFruits[j] = fruits[i];
                j++;

            }

        }
        System.out.println("------------------------------------------");

        System.out.println("\nAvailable fruits after delete : " + newFruits.length + "\n");

        // print the final output
        for (String s : newFruits) {
            System.out.println(s + " is Available\n");
        }

    }

    public static void main(String args[]) {

        new DeleteValue().delete("mango");
        ;
    }

}