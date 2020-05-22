public class NumberInWordsFormatter implements Formatter<Number,String> {

    @Override
    public String format(Number input) {
        String numberInWords = input.toString();
        //logic for converting a number to words
        return numberInWords;
    }

}