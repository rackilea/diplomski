try {
    port.removeEventListener()
} catch (SerialPortException e) {
    if (e.getExceptionType().equals(SerialPortException.TYPE_CANT_REMOVE_LISTENER)) {
        // the listener hasn't been added
    } else {
        // other exceptions
    }
}