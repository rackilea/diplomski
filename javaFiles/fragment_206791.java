public static void main(String[] args) {
        //JTextField fileName = new JTextField();
        Object[] message = {"File name"};
        String option = JOptionPane.showInputDialog(null, message, "Add New", JOptionPane.OK_CANCEL_OPTION);
        if (option == null)
        System.out.println("Cancell is clicked..");
        else
        System.out.println(option+ " is entered by user");
    }