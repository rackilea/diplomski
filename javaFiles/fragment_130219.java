String[] headers = {"Number of Games Played:", "Total Score:", "Average Score:"};
JTextArea textArea = new JTextArea(3, 20);
// Add text area to container

try (BufferedReader br = new BufferedReader(new FileReader(new File("history.txt")))) {
    String text = null;
    int lineCount = 0;
    while ((text = br.readLine()) != null && lineCount < 3) {
        System.out.println(text);
        textArea.append(headers[lineCount] + " " + text + "\n");
        lineCount++;
    }
} catch (IOException ex) {
    ex.printStackTrace();
}