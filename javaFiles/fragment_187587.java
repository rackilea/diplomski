} else if (src == create) {
    //show an input dialog box
    String s = JOptionPane.showInputDialog(this, "What do you want to remember?");

    /*f the length of the given string is zero, or if the length of the string without spaces
        is zero, then tell the user*/
    if (s.trim.length() == 0) {
        System.out.println("Nothing has been entered");
        JOptionPane.showMessageDialog(this, "You must enter a text value!");
        //if the string is valid, add it to the file
    } else {
        sfile.add(s);
        System.out.println("Item added to list. " + s.length());
    }

} else if (src == close) {
    System.exit(0);
}