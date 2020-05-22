public class ControlPanelOne {

    private JPanel panel;
    private JButton button;

    public ControlPanelOne(final Controller controller){
        panel = new JPanel();
        button = new JButton("press me");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //do some stuff;

                controller.update();

            }
        });
    }


    public Component getPanel() {
        return null;
    }
}