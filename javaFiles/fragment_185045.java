@Override
public void uploadStarted(StartedEvent event) {
    // TODO Auto-generated method stub
    System.out.println("***Upload: uploadStarted()");

    String contentType = event.getMIMEType();
    boolean allowed = false;
    for(int i=0;i<allowedMimeTypes.size();i++){
        if(contentType.equalsIgnoreCase(allowedMimeTypes.get(i))){
            allowed = true;
            break;
        }
    }
    if(allowed){
        fileNameLabel.setValue(event.getFilename());
        progressBar.setValue(0f);
        progressBar.setVisible(true);
        cancelButton.setVisible(true);
        upload.setEnabled(false);
    }else{
        Notification.show("Error", "\nAllowed MIME: "+allowedMimeTypes, Type.ERROR_MESSAGE);
        upload.interruptUpload();
    }

}