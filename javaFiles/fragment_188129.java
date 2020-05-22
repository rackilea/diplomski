back.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
staffManagment back = new staffManagment(""); 
back.setVisible(true); 
setVisible(false); 
frame.dispose(); 
} 
});