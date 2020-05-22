//Note: "this" should be the Container that directly contains your components
//(most likely a JPanel).
//This won't work if you call getComponents on the top-level frame.
for (Component C : this.getComponents())
{    
    if (C instanceof JTextField || C instanceof JTextArea){

        ((JTextComponent) C).setText(""); //abstract superclass
    }
}