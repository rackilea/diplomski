Path p = Paths.get("p022_names.txt");
try {
    List<String> lines = Files.readAllLines(p); // throws java.io.IOException
    System.out.println(lines.size()); // Only one line in file.

    // Remove all " (double quotes) characters.
    String tmp = lines.get(0).replaceAll("\"", "");

    String[] names = tmp.split(",");
    System.out.println(names.length);
    Arrays.sort(names);

    // Test against example given in problem description.
    System.out.println(names[937]); // Should be COLIN
    char[] lett = names[937].toCharArray();
    int sigma = 0;
    for (int k = 0; k < lett.length; k++) {
        sigma += lett[k] - 'A' + 1; // Since only uppercase letters in file.
    }
    int score = sigma * (937 + 1);
    System.out.println(score); // Should be 49714

    // Now obtain answer, i.e. the total of all the name scores in the file.
    int total = 0;
    for (int i = 0; i < names.length; i++) {
        char[] letters = names[i].toCharArray();
        int sum = 0;
        for (int j = 0; j < letters.length; j++) {
            sum += letters[j] - 'A' + 1;
        }
        total += sum * (i + 1);
    }
    System.out.println(total);
}
catch (IOException xIo) {
    xIo.printStackTrace();
}