String identifier = "duck";

    try {
        int result = Integer.parseInt(identifier);
    }
    catch(Exception e) {
        log.log(Level.SEVERE, "Failed to parse the identifier.", e);
    }