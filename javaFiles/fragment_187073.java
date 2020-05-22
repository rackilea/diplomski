public static void outputFile() {
    File path = new File("output.txt");
    try (FileOutputStream fout = new FileOutputStream(path);
          PrintWriter dos = new PrintWriter(fout)) {
        while (!stackHabitItems.isEmpty()) {
            HabitItemit = stackHabitItems.pop();
            dos.println("<");
            for(int i = 0; i < 7; i++) {
                if (it.isDayCompleted[i]) {
                    dos.print(1);
                }
                else {
                    dos.print(0);
                }
            }
            dos.println();

            dos.print(it.id);

            dos.println("\\>");
        }
    } catch (Exception e) {
        System.out.println("Failed to open file output.txt");
    }
}