myComponent.add<Any>Listener(new <Appropriate>Listener(){
    @Override
    public void <AppropriateMethod>(like KeyPress)>(<Appropriate>Event e) {
        int stateMask=e.stateMask;
        if((stateMask & SWT.ALT)==SWT.ALT){
            <Do_appropriate_actions>;
        }
        if((stateMask & SWT.CTRL)==SWT.CTRL){
            <Do_another_appropriate_actions>;
        }
        if((stateMask & SWT.SHIFT)==SWT.SHIFT){
            <Do_an_even_more_appropriate_actions_cause_you_are_kind_of_a_code_roxxor_!>;
        }
    };
};