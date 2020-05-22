public class RegexPlayground {
    public static void main(String[] args){
        Pattern pattern=Pattern.compile("B.N...");
        String word="BANANA";
        Matcher matcher = pattern.matcher(word);
        if(matcher.find()){
            System.out.println("Found matching word \""+word+"\"");
        }
        word="BASKET";
        matcher = pattern.matcher(word);
        if(matcher.find()){
            System.out.println("Found matching word \""+word+"\"");
        }else{
            System.out.println("No match on word \""+word+"\"");
        }
    }
}