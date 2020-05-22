try {
    Class.forName(driverClassName);
    // Success.
}
catch (ClassNotFoundException e) {
    // Fail.
}