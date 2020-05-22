public class words {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please type a phrase.");
        String phrase= in.nextLine();

        String[] words = phrase.split(" ");

        System.out.println("The number of words is:"+words.length);

        for(int i=0; i<words.length; i++){
            System.out.println(words[i]+" is "+words[i].length()+" letters long.");

        }
    }
}