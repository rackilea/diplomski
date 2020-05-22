// Your words should be in a TreeSet to be already sorted alphabetically 
// in order to get a match as fast as possible
Set<String> words = new TreeSet<String>(); //this set is already populated
int index = word.indexOf('.');
if (index != -1) {
    String prefix = word.substring(0, index);
    String suffix = word.substring(index + 1);
    boolean match = false;
    for (String setWord : words){
        // From the fastest to the slowest thing to check 
        // to get the best possible performances
        if (setWord.length() == word.length() 
            && setWord.startsWith(prefix) 
            && setWord.endsWith(suffix)) {
            match = true;
            break;
        }
    }
    if(match)
        System.out.println("Its a match");
    else
        System.out.println("Its not a match");
}
else {
    System.out.println("The word does not contain regex do other stuff");
}