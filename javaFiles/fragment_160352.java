private static final String DELIM = ",";
public static void main(String args[]) throws Exception {
    // ...
    // read the file content line by line with BufferedReader

    String line = "5,37,2,-7";
    String splitted[] = line.split(DELIM);
    byte[] result = new byte[splitted.length];

    for (int n = 0; n < splitted.length; ++n) {
        result[n] = Byte.parseByte(splitted[n]);
    }

    System.out.println(Arrays.toString(result));
}