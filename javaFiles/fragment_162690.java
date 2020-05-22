public static void main(String[] args) {
        String text = "There are two bread which are very cool bread.";
        String bread = "bread";
        //make a new string by taking everything from first index of bread string+length of a bread string word and the last index of bread.
        String inBEtween = text.substring(text.indexOf(bread)+bread.length(), text.lastIndexOf(bread));
        //if the length inbetween trimmed of leading and tailing whitespace is greater than 0, print inBetween, otherwise print "No sandwich".
        if (inBEtween.trim().length() > 0) {
            System.out.println(inBEtween);
        } else {
            System.out.println("No sandwich.");
        }
    }