private static void showFrames(Map<String,String> longToShortNameMap) {
    JFrame frame = new JFrame("Data Changed");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(400, 500);
    frame.setResizable(true);
    frame.setLocationRelativeTo(null);
    JPanel panel = new JPanel(new GridLayout(0, 2)); //use gridlayout
    List<String> keys = new ArrayList(longToShortNameMap.keySet());
    for (String key : keys) {
        JLabel label = new JLabel(key); // your label is the key itself
        JTextField textField = new JTextField(longToShortNameMap.get(key));
        panel.add(label);                     // Populate textfield with the key's value
        panel.add(textField);
    }
    frame.add(panel);
}