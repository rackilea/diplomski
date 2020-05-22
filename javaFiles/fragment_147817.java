public class WordCountstackquestion implements Runnable {

    private String filename;

    public WordCountstackquestion(String filename) {
        this.filename = filename;
    }

    public void run() {
        int count = 0;
        try {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            Scanner in = new Scanner(new File(filename));

            while (in.hasNext()) {
                String word = in.next();

                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else {
                    map.put(word, 1);
                }
                count++;

            }
            System.out.println(filename + " : " + count);

            for (String word : map.keySet()) {
                System.out.println(word + " " + map.get(word));

            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " was not found.");
        }
    }

}