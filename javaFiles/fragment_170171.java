try {
        //something that will error
    } catch (DefaultException e) {
        String errorCode = e.getErrorCode();
        // ...
    }