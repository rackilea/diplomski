public class KeyAction extends AbstractAction {
    Punto p;
    Component c;
    public KeyAction(Punto p, Component c, String actionCommand) {
       this.p = p;
       this.c = c;
       putValue(ACTION_COMMAND_KEY, actionCommand);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvt) {
       if(actionEvt.getActionCommand().equals("VK_LEFT"))
           p.moveLeft();
       if(actionEvt.getActionCommand().equals("VK_RIGHT"))
           p.moveRight();
       if(actionEvt.getActionCommand().equals("VK_UP"))
          p.moveUp();
       if(actionEvt.getActionCommand().equals("VK_DOWN"))
          p.moveDown();

       c.repaint();
    }
 }