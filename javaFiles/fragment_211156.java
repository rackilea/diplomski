public class SpellChecker {
    private Scanner scan;
    private HashSet<String> hset;
    private HashMap<String, ArrayList<Integer>> hmap;
    private ArrayList<Integer> myList;

    public SpellChecker(){
        scan = new Scanner(System.in);
        hset = new HashSet<String>();
        hmap = new HashMap<String, ArrayList<Integer>>();
        myList = new ArrayList<Integer>();
    }

}