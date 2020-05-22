File file = ...;
try {
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] values = line.split("-");
        String rank = values[0].replace("[", "").trim();
        String suite = values[1].replace("]", "").trim();
        System.out.println(rank + " of " + suite + " - Value = " + rank); // *****
    }
} catch (Exception e) {
    e.printStackTrace();
}