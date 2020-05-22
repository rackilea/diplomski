public class Util {
    /*
     * Checks if the given string is a relevant feature
     * returns boolean true if input string qualifies as a relevant feature
    */
    static public boolean isFeature(String s) {

       List<String> irrelevant = Arrays.asList( "a", 
                                                "an",
                                                "but",
                                                "how",
                                                "will",
                                                "this",
                                                "that",
                                                "them",
                                                "they",
                                                "there",
                                                "these"
                                );

       return !(irrelevant.contains(s));
    }
 }