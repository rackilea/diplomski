//Moved vote1/2 here outside of the method
static int vote1 = 0;
static int vote2 = 0;

    private void vote1ActionPerformed(java.awt.event.ActionEvent evt){                                      
        //We removed vote1 and vote2 from here and put them above
        if (koonchk.isSelected()){
        vote1++;
        koontf.setText(Integer.toString(vote1));
        }
        else if (baamchk.isSelected()){
        vote2++;
        baamtf.setText(Integer.toString(vote2));
        }
    }