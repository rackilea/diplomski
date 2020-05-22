public class MainPanel entends JPanel {
    CardLayout layout = new CardLayout(); <-- card layout
    JPanel panel = new JPanel(layout);    <-- set layout to main panel
    NewPanel newPanel = new NewPanel();   <-- you new panel
    JPanel p1 = new JPanel();             <-- random panel
    JTextField text = new JTextField()    <-- text field in form
    JButton button = new JButton();

    JComboBox cbox = new JComboBox(new String[] {"newPanel", "p1"});  <-- hold panel names

    public MainPanel(){
        panel.add(newPanel, "newPanel");       <-- name associated with panel
        panel.add(p1, "p1");

        ...

        cbox.addAItemListener(new ItemListener(){
            public void itemStateChnaged(ItemEvent e){

                layout.show(panel, (string).getItem());     <-- show Panel from combobox
            }
        });

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String txt = text.getText();
                newPanel.printText(txt);             <-- Using method from other class    
            }
        });
    }
}  

public class NewPanel extends JPanel {

    public void printText(String text){             <-- method from other class
        System.out.println(text);
    }
}