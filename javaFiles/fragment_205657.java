public static void main(String[] args) throws FileNotFoundException {
    String x;
    Scanner scanner = new Scanner(new File("Book1.csv"));
    while(scanner.hasNextLine()){                // If there is another line in the file
        x = scanner.nextLine();                  // Extract that line
        String[] values = x.split(",");          // Split that line at the commas
        if (!values[0].equals("")) {             // If the first value is not equal to empty
            System.out.print(x);                 // Print the line
        }
    }
    scanner.close();
}