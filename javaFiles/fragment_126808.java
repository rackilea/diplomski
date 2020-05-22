boolean button1ClickedLast = false;

public void mouseClicked(java.awt.event.MouseEvent e){
    if (e.getSource() == jButton1) {
        button1ClickedLast = true;
        System.out.println ("Bye");
    }
    else  if (e.getSource() == jButton2) {
        if(button1ClickedLast) {   
            System.out.println ("Hello");
        }
        else{
            // do nothing or something if you want
        }

    }
    else {
        button1ClickedLast = false; // to change status to false in case any other button is clicked last
    }

}