public class FirstJPanel extends JPanel{
    private List<ActionListener> buttonActionListeners;
    //... 
    public FirstJPanel(){
        init();
    }
    private void init(){
        buttonActionListeners = new ArrayList<>();
        //
        JButton myButton = new JButton("Click Me!");
        myButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(ActionListener listener: buttonActionListeners){
                    listener.actionPerformed(e);
                }
            }
        });

        // ...
    }

    // ...

    public void addMyButtonActionListener(ActionListener a){
        if(!buttonActionListeners.contains(a))
            buttonActionListeners.add(a);
    }

    public void removeMyButtonActionListener(ActionListener a){
        buttonActionListeners.remove(a);
    }
}