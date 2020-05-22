private int buttonClicks = 0; // Or public
public void actionPerformed(ActionEvent e)
        {
             if(buttonClicks == 14){
               System.exit(0); // Or a different script
             }else{
             JButton button = (JButton)e.getSource();
             button.setEnabled( false );
             buttonClicks++; // Record click
             }
        }