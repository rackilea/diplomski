public ArrayList<JButton> list = new ArrayList<JButton>();
//...

public void setButtons(int nButtons){     //nButtons=number of buttons you'd need
  for (int i =0; i<nButtons; i++)
  { 
   this.list.add( new Jbutton("here include whatever you want for your button"));
  }
 }