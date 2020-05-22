@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == showButton) {
        add(mypanel(), BorderLayout.PAGE_START); // set another position or remove previous component here
        validate(); 
        System.out.println("show button clicked");

    }
}