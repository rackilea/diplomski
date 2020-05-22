class MyTableUI extends BasicTableUI {
    ...

    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
        final ActionMap actionMap = getTable().getActionMap();
        actionMap.put( NEXT_ROW, 
            new MyNewRowSelectionAction( NEXT_ROW, actionMap.get( NEXT_ROW ) ) );
        ...