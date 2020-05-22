public static void main(String args[]) {
    try {
        JOptionPane.showMessageDialog(null, "", "", 
            JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(new URL("http://marinerczarter.pl/wp-content/themes/twentyten/images/headers/path.jpg")));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } 
}