// Use a list since the length of the file is unkown
List<Sleg> slegs = new ArrayList<Sleg>();

File slFile = new File("slFile.txt");

// Use try-with-resources block so the reader is closed automatically,
// no need to use Scanner since we're only interested in reading lines...
try (BufferedReader reader = new BufferedReader(new FileReader("slFile.txt"))) {

    // Read the file line by line
    String line;
    while ((line = reader.readLine()) != null) {
        // Split the line, convert values, and add new sleg.
        String[] numbers = line.trim().split(" ");
        int i = Integer.parseInt(numbers[0]);
        int j = Integer.parseInt(numbers[1]);
        double l = Double.parseDouble(numbers[2]);
        slegs.add(new Sleg(i, j , l));
    }

} catch (FileNotFoundException e) {
    System.out.println(slFile.toString() + " does not exist.");
} catch (IOException e) {
    // Handle any possible IOExceptions as well...
    System.out.println("Unable to read : " + slFile.toString());
}