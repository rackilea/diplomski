boolean hasclicked1=false;
JLabel click1label=null;

public void mouseClicked(MouseEvent me){
  if(!hasclicked1){ //clicked first pic
    hasclicked1 = true;
    click1label = (JLabel) me.getSource();
  } else { //clicked second pic
    hasclicked1 = false;
    exchangeComponents(click1label, (JLabel) me.getSource(), /*your jpanel here*/);
  }
  //now change exchangeComponents so it uses JLabels as parameters
public void exchangeComponents(JLabel component1, JLabel component2, JPanel jpanel){
  try{
    Component aux1 = component1;
    Point aux1Loc = aux1.getLocation();
    Component aux2 = component2;
    Point aux2Loc = aux2.getLocation();
    aux1.setLocation(aux2Loc);
    aux2.setLocation(aux1Loc);
  } catch (java.lang.ArrayIndexOutOfBoundsException ex) { /* error! bad input to the function*/
   System.exit(1);
  }
}