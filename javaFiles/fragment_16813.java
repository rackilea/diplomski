private static long length;

public static void main(String[] q) throws IOException {

        // This is for the character mapping
        Scanner console = new Scanner(System.in);
        System.out.println("Count characters of which file? ");
        File file = new File(console.nextLine());
        FileInputStream output = new FileInputStream(file);
        length = file.length();
        Map<Character, Integer> results = getCounts(output);
        // do stuff with this map later on...
    }

    // character counting method (WIP)
    public static Map<Character, Integer> getCounts(FileInputStream input) throws IOException {
        Map<Character, Integer> output = new TreeMap<Character, Integer>(); // treemap keeps keys in sorted order (chars alphabetized)
        // Problem here: need to access the file object that was instantiated
        byte[] fileContent = new byte[(int) length]; // puts all the bytes from file into byte[] to process
        input.read(fileContent);
        String test = new String(fileContent);
        System.out.println("test = " + test);

        // missing stuff here; use map to map keys as characters and occurrences as values.

        return output;
    }