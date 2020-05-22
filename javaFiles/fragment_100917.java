public class FileLoad {

    public static String[] readHotelArray(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        bufferedReader.close();

        return lines.toArray(new String[lines.size()]);
    }

    public static void writeHotelArray(String filename, String[] hotel) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, false));
        //Write each string from the array to the file as a new line
        for (String s : hotel)
            bufferedWriter.write(s + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}