public static void main(String args[]) {
    String fruits[] = {"Apple", "Orange", "Banana"}; //put whatever fruit values you want in here
    List<String> output = new ArrayList<>();
    try (Scanner s = new Scanner(new BufferedReader(new FileReader("Test.txt")))) {
        while (s.hasNext()) {
            String line = s.nextLine();
            line = line.replaceAll("#", String.valueOf(randomNumber(1, 9)));
            line = line.replaceAll("fruit", fruits[randomNumber(0, fruits.length-1)]);
            line = line.replaceAll("date", new SimpleDateFormat("YYYYMMDD").format(new Date()));
            output.add(line);
        }
    } catch (FileNotFoundException ex) {
        System.out.println("Unable to open file.");
    }

    for (String line : output) {
        System.out.println(line);
    }
}

private static int randomNumber(int min, int max) {
    Random rand = new Random();
    return rand.nextInt((max - min) + 1) + min;
}