// do some computations...

// this will block while there are other updates pending:    
updateQueue.put(() -> {
    // code to update UI
    // note this does not need to be explicitly executed on the FX application
    // thread (no Platform.runLater()). The animation timer will take care of that
});

// do some more computations