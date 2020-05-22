@Override
    public void dropAccept( DropTargetEvent event )
    {
        Object object = FileTransfer.getInstance().nativeToJava( event.currentDataType );
        if( object instanceof String[] )
        {
            String[] strs = (String[]) object;
            System.out.println("dropAccept " + strs[0]);
            event.detail = DND.DROP_COPY;
        }
        event.detail = DND.DROP_COPY;
    }
    @Override
    public void dragEnter( DropTargetEvent event )
    {
        event.detail = DND.DROP_COPY;
    }