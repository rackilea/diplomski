public class JFMarchMadness extends javax.swing.JFrame {

ArrayList<BasketballTeam> alCTeams=new ArrayList <>();

public JFMarchMadness() 
{
    initComponents();
}

//creates arraylist and loads up data from arraylist of type string (lstConfTeams)
void createCTArrayList ()
{
    String CTteamName;
    String CTstatus="";
    int CTwins=0;
    int CTlosses=0;
    double CTwinLossPct=0;

    for (int iCount = 0; iCount <lstConfTeams.getModel().getSize(); iCount++)
    {
        CTteamName=lstConfTeams.getModel().getElementAt(iCount);
        alCTeams.add(new BasketballTeam(CTstatus,CTteamName,CTwins,CTlosses,CTwinLossPct));
    }

}

private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {                                     
// call createCTArrayList method and begin for loop


    createCTArrayList ();

    int iCTCount;

    for (iCTCount=0; iCTCount<alCTeams.size; iCTCount++){
    //
    }
}