public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame frame = new JFrame("JFormattedTextField Example");
            MaskFormatter fmt = null;

            // A phone number 10 digits 
            try {
                fmt = new MaskFormatter("(###)-###-####");//brackets () are optional just there for my pref
                fmt.setPlaceholderCharacter('*');//set place holder for the empty digits of the number

            } catch (java.text.ParseException e) {
            }

            JFormattedTextField tft1 = new JFormattedTextField(fmt);

            frame.add(tft1);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }
    });
}