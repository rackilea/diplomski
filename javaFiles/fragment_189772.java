dialog.initModality(Modality.APPLICATION_MODAL);
dialog.show();            

loginButton.addEventFilter(EventType.ROOT, 
    e->{
        if(e.getEventType().equals(ActionEvent.ACTION)){                
            e.consume();
            // (hardcoded) Login Validation
            boolean isSuccessful = false;
            if (isSuccessful) {
                dialog.close();
            }
            else {
                // perform animation and close the dialog (or any other action)
                ShakeTransition anim = new ShakeTransition(dialog.getDialogPane(), t->dialog.close());
                anim.playFromStart();
            }
        }
    });