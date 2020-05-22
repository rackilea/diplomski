input = JOptionPane.showInputDialog(null,"host name", "name", JOptionPane.INFORMATION_MESSAGE); 

if (input != null && input.equals("")) {
    clientSocket = new Socket(input, 7777);
    // Socket created
} else {
    // Else not ...