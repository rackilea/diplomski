int result = JOptionPane.showOptionDialog(null, //Component parentComponent
                           "How do you want to get to Jim's?", //Object message,
                           "Transportation Method", //String title
                           JOptionPane.YES_NO_OPTION, //int optionType
                           JOptionPane.INFORMATION_MESSAGE, //int messageType
                           null, options, options [0]); //Icon icon, 
if(result == 0) System.out.println ("Test Option 1");
else System.out.println ("Test Option 2");