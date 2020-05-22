public static class GUI extends JFrame {
    //...
    private XMLEmployeeModel model;

    GUI(XMLEmployeeModel model) {

        super("XML Writer");

        this.model = model;
        //...
    }

    private class Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String fn = "";
            String ln = "";
            String sal = "";

            fn = firstName.getText();
            ln = lastName.getText();
            sal = salary.getText();

            model.insert(fn, ln, sal, sal);

            JOptionPane.showMessageDialog(null, "Information stored in XML file");

        }

    }

}