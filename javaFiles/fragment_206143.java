public SearchScreen(){

        userQuery = (String) JOptionPane.showInputDialog("Type Keywords in english to be requested below:");

            try {

                 //Your Action with the String  

            } catch (IOException e1) {

                e1.printStackTrace(); //print failure
                    JOptionPane.showMessageDialog(null, "FAILURE");
            }

    }