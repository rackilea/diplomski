public class DictClass {

    private  Set<String> dictionary = new HashSet<String>();

    //... cunstructors, getters, setters

    void readFile(String fileName) {
        try {
            Scanner textFile = new Scanner(new File(fileName));

            while (textFile.hasNext()) {
                // now dictionary is not recreated each time
                dictionary.add(textFile.next().trim());
            }

            textFile.close();

            for (String str : dictionary) {
                System.out.print(str + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}