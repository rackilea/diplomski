public class Tree {
    ArrayList<String[]> storing;

    public Tree() throws Exception {
        File file = new File("C:/Users/joaki/Desktop/burma14.tsp");
        Scanner sc = new Scanner(file);
        storing = new ArrayList<String[]>();
        String nextValue = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if("NODE_COORD_SECTION".equals(line)){
                while (sc.hasNextLine()) {
                    nextValue = sc.nextLine();
                    storing.add(nextValue.trim().split(" "));
                }
            }
        }
        sc.close();
    }

    public static ArrayList<String[]> returnScanner() throws Exception {
        Tree tree = new Tree();
        return tree.storing;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String[]> storedValues = returnScanner();
        String[] firstLine = storedValues.get(0);
        String[] secondLine = storedValues.get(1);
        for (int i = 0; i < firstLine.length; i++) {
            System.out.println(firstLine[i]);
        }
    }
}