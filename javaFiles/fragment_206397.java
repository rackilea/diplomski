Person thePerson = null; // note, don't call variables theAnything... it's just bad

JComboBox theBox = new JComboBox(new String[]{"Accountant","Soldier","Programmer"});



// later

public void actionPerformed(ActionEvent e) {
        if(e.getSource() == theBox) {
            String who = (String)theBox.getSelectedItem();
            if(who.equals("Accountant") thePerson = new Accountant();
            if(who.equals("Soldier") thePerson = new Soldier();
            if(who.equals("Programmer") thePerson = new Programmer();
        }
}