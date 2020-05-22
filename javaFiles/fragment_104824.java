public class Main {

    public static void main(String[] args) {
        DogItem dogItem = new DogItem("Spot", "Dalmation", "45", "Bob", "Sandy");
        DogItem.add(dogItem);

        DogItem result = DogItem.searchForItem("Spot");

        if (result == null) {
            System.out.println("Dog not found");
            // GUI error output goes here
        } else {
            System.out.println("Here is your obj value: " + result);
            // Where your GUI stuff goes
        }
    }
}