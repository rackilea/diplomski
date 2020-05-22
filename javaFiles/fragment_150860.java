private void call(String number) {
    try {
    platformRequest("tel:" + number);
    } catch (ConnectionNotFoundException ex) {
    // TODO: Exception handling
    }
    }