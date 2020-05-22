JFileChooser chooser = new JFileChooser();
if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
File myfile = chooser.getSelectedFile();
try {

    Scanner in = new Scanner(myfile);

    int counter = 0;
while(in.hasNextLine()){
 String word = in.nextLine();
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == 'a') {
            counter++;
        }
    }
}

    System.out.println("# of chars: " + counter);
} catch (IOException e) {
    System.err.println("A reading error occured");
}
}