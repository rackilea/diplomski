String[] headers = {"Number of Games Played:", "Total Score:", "Average Score:"};
JLabel[] labels = new JLabel[3];
for (int index = 0; index < labels.length; index++) {
    labels[index] = new JLabel();
    // Add label to screen
}

try (BufferedReader br = new BufferedReader(new FileReader(new File("history.txt")))) {
    String text = null;
    int lineCount = 0;
    while ((text = br.readLine()) != null && lineCount < 3) {
        System.out.println(text);
        labels[lineCount].setText(headers[lineCount] + " " + text);
        lineCount++;
    }
} catch (IOException ex) {
    ex.printStackTrace();
}