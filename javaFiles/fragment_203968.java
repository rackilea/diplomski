public class MainMenu {
    private CardLayout layout;
    private Frame frame;

    public MainMenu(final Frame frame) {
         this.frame = frame;
         this.layout = (CardLayout)frame.getLayout();

         JButton buttonSingle = new JButton("Single");     
         buttonSingle.setAlignmentX(Component.CENTER_ALIGNMENT);
         buttonSingle.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 layout.show(frame, "single");
             }
         });
    }
}