class HomeCommand extends AbstractAction {

 private final Action action;

    public HomeCommand(Action action){
         this.action=action;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(doSomethingSpecial())
            performSpecialHomeAction();
        else
            action.actionPerformed(ev); 
    }
}