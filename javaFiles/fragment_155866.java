public class SorterDriver {
    public static void main(String[] args) {
        List<String> toSort = new ArrayList<String>();

        toSort.add("fizzbuzz");
        System.out.println("toSort size is " + toSort.size());

        Collections.sort(toSort);
        if(toSort == null) {
            System.out.println("I am null and sad.");
        } else {
            System.out.println("I am not null.");
        }
    }
}