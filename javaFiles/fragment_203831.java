public static void main(String[] args) {
        System.out.println("Encoding: " + System.getProperty("file.encoding"));
        JTextArea area = new JTextArea(10, 30);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, pane);
        String text = area.getText();
        char sqrt = '\u221A';
        if (text.contains(Character.toString (sqrt))) {
            System.out.println("YES for " + text);
        } else {
            System.out.println("NO for " + text);
        }
    }