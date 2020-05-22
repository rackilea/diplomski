// Parent Class
public class ParentClass{
//Field you want to mess with in your action
   JLabel cursorlbl = new JLabel("");

    // Action that does things
    public class MoveAction extends AbstractAction{
        char direction;

        //Constructor for action
        public MoveAction(char direction){
            this.direction = direction;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            int change = 0;

            // Figure out how you'll be changing the variable
            if(direction == 'u' || direction == 'r'){
                change = 1;
            } else{
                change = -1;
            }

            // Apply the change to the correct variable
            if(direction == 'u' || direction =='d'){
                cursy += change;
            } else{
                cursx += change;
            }

            //Example how you can access the parent class's fields
            cursorlbl.setLocation(cursx, cursy);
        }       
    }
}