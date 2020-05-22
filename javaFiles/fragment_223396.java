File file = chooser.getSelectedFile();
System.out.println("You chose to open this file: " + file.getName() + "\n");

String newFile = "Parsed_" + file.getName();

// open all closable objects using try-with-resources 
try (Scanner userFile = new Scanner(file); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {

   while (userFile.hasNextLine()) {
      String document = userFile.nextLine();
     // Line breaks used by Parser
     String[] sentences = document.split("\\.|\\?|\\!|\\r");

    for (String s : sentences) {
        if (s.contains("Should") || s.contains("should")) {
            System.out.println(s);
            bw.append(s);
            bw.newLine();
      }
   } 

   System.out.println("\nParsed Document Created: " + newFile);

  JOptionPane.showMessageDialog(null, "Parsed Document Created: " + newFile);
   // bw.close(); // not needed anymore