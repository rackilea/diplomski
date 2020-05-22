public class ComponentExchanger implements MouseListener {
boolean hasclicked1=false;
JLabel click1label=null;
JPanel mainPanel;
public ComponentExchanger(){
   //create JFrame, JPanel, etc.
   JFrame f=new JFrame();
   //etc.
   mainPanel=new JPanel();
   f.add(mainPanel);
   //set layout of panel, etc.
   for(int i=0;i<9;i++){
      JLabel l=new JLabel(/*label image here*/);
      Point loc=new Point(/*coordinates here*/);
      l.setLocation(loc);
      mainPanel.add(l);
      /*more code*/
      f.setVisible(true);
   }
}

public static void main(String args[]){
   new ComponentExchanger();
}


public void mouseClicked(MouseEvent me){
  if(!hasclicked1){ //clicked first pic
    hasclicked1 = true;
    click1label = (JLabel) me.getSource();
  } else { //clicked second pic
    hasclicked1 = false;
    exchangeComponents(click1label, (JLabel) me.getSource(), mainPanel);
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

//Also, you will need to include the other mouselistener implemented methods, just 
//leave them empty
}