public class SelectionForm extends WindowAdapter implements  ActionListener 
{
    private JButton reselect;
    void select() {

        ...
        //submit button
        reselect = new JButton(" Re-select ");
        reselect.setVisible(false);


        ....
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected: " + e.getActionCommand());

        if(e.getActionCommand().equals("Laptop") || (e.getActionCommand().equals("Desktop"))){

            //OnlineShop oS = new OnlineShop();
            // oS.onlineShop();

            reselect.setVisible(true);
        }
    }

}

class MyWindowListener extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.out.println("Closing window!");
        System.exit(0);

    }
}