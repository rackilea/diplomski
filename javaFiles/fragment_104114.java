File newFile = new File("/path/to/file.png");
    ActionProxy proxy = getActionProxy("/uploadAction");        
    UploadAction action = (UploadAction) proxy.getAction();                

    action.setMyUploadFile( newFile );
    String result = proxy.execute();