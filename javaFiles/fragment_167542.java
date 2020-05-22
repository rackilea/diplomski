public class YourClass {
    public static void main(String[] args) {
        String[] names = { "bob", "maxwell", "charley", "tomtomjack" };
        int amountOfLetters = countAllLetters(names);

        System.out.println(amountOfLetters);
    }

    public static int countAllLetters(String[] array) {
        int sum = 0;
        for(String s : array)
            sum += s.length();
        return sum;
    }
}