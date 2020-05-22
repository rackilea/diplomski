BufferedReader br = new BufferedReader(...); // Initialize a buffered reader reading from that text file.
String line;
while ((line = br.readLine() != null) {
    String name = line.split(";")[0];
    String score = line.split(";")[1];
    namesTextArea.append(name + "\n");
    scoresTextArea.append(score + "\n");
}