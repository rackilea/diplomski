if( oppComp == null ){
    final Component srcComp = (Component)focusEvent.getSource();
    FocusTraversalPolicy ftp = impl.mainFrame.getFocusTraversalPolicy();
    Component lastComp = ftp.getLastComponent( impl.mainFrame );
    Component beforeComp = ftp.getComponentBefore( impl.mainFrame, srcComp );

    if( lastComp == beforeComp ){
        EventQueue.invokeLater( new Runnable(){
            public void run() {
                if( impl.mainFrame.isFocused()){
                    srcComp.requestFocus();
                };
            }});
    }
}