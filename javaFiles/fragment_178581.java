String filename;
filename = "Details.txt";

List<String[]> alist = new ArrayList<String[]>();

try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

    String nextLine = null;
    while ((nextLine = bufferedReader.readLine()) != null) {
        String[] parts = nextLine.split(" ");
        String[] elements = new String[parts.length - 1];
        elements[0] = parts[0] + " " + parts[1];
        System.arraycopy(parts, 2, elements, 1, elements.length - 1);
        alist.add(elements);
    }
} catch (IOException e) {
    System.out.println("Error reading from file: " + e);
}
for (String[] values : alist) {
    System.out.println(Arrays.asList(values));
}