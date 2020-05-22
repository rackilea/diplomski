String word = JOptionPane.showInputDialog("Enter a String:");
        String finalword = "";
        int x;
        for (x = word.length()-1; x >= 0; x--) {
            finalword = finalword + word.charAt(x);
        }
        if (word.equals(finalword)) {
            JOptionPane.showMessageDialog(null, "Palindrome");
        } else {
            JOptionPane.showMessageDialog(null, "Not a Palindrome");
    }