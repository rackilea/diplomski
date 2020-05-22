public class ViewControlListener implements ActionListener {

    private Model model;
    private View view;

    public ViewControlListener(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        //update model
        //refresh view
    }

}