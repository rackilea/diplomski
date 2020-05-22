public static void main(String[] args) throws FileNotFoundException {
    Scanner s = new Scanner(new File("numbers.txt"));
    List<Integer> numbersList = new ArrayList<Integer>();
    while (s.hasNextLine()) {
        String[] numbers = s.nextLine().split(" ");
        for (String n : numbers)
            try {
                numbersList.add(Integer.parseInt(n));
            } catch (NumberFormatException nfe) {
                System.err.println("Not an integer: " + n);
            }
    }
    System.out.println(numbersList);
}