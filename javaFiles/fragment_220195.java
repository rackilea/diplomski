public class LOLUnknowns1d {
    static void nowDefinitelyIllegal(List<? extends List<?>> lol, List<?> list) {
        lol.add(list); // DOES NOT COMPILE!!!
            // The method add(capture#1-of ? extends List<?>) in the
            // type List<capture#1-of ? extends List<?>> is not 
            // applicable for the arguments (List<capture#3-of ?>)
    }
    public static void main(String[] args) {
        List<Object> list = null;
        List<List<String>> lolString = null;
        List<List<Integer>> lolInteger = null;

        // these casts are valid
        nowDefinitelyIllegal(lolString, list);
        nowDefinitelyIllegal(lolInteger, list);
    }
}