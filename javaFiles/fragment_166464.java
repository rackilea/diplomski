public class ReadGraph {
    static int vertNum = 0;
    static String[] output;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileIn = null;
        for (String s : readVertices(fileIn)) {
            System.out.println(s);
        }
    }

    public static String[] readVertices(Scanner fileIn) throws FileNotFoundException {
        fileIn = new Scanner(new File("input.txt"));
        vertNum = fileIn.nextInt();
        output = new String[vertNum];
        for (int i = 0; i < vertNum; i++) {
            output[i] = fileIn.next();
        }
        Arrays.sort(output);
        fileIn.close();
        return output;
    }
}