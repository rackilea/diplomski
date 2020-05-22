public class PI_list {

    public static String countOccurences(String letter, List<String> array) {
        int counter = 0;
        for (String s : array) {
            if (s.equals(letter))
                counter++;
        }
        return letter + ": " + String.valueOf(counter);
    }

    public static void getResult(List<String> array) {
        Set<String> setOfLetters = new HashSet<String>();
        List<String> dataArray = new ArrayList<String>();
        for (String s : array) {
            s.replace("[", "");
            s.replace("]", "");
            String tab[] = s.split(",");
            setOfLetters.add(tab[0]);
            dataArray.add(tab[0]);
        }
        for (String s : setOfLetters)
            System.out.println(countOccurences(s, dataArray));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("/home/tab.csv"));
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();
            ArrayList<String> PPIData = new ArrayList<String>();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("\t");
            while (scanner.hasNext()) {
                PPIData.add(scanner.next());
            }
            getResult(PPIData);
            System.out.println(PPIData);
        }
        inputFile.close();
    }

}