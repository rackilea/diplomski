public static void writeAssignment(ArrayList<String> assignment, String filename) throws FileNotFoundException {

    try (FileWriter writer = new FileWriter(filename)) {
        for (String str : assignment) {
            writer.write(str + "\n");
        }
    } catch (FileNotFoundException e) {
        throw e; // catch and re-throw
    } catch (IOException e) {
        System.err.print("Something went wrong");
    }
}