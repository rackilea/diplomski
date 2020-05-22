catch (Exception e) {
    // this is the line of code that sends a real error message to the
    // log
    Log.e("ERROR", "ERROR IN CODE: " + e.toString());
    // this is the line that prints out the location in
    // the code where the error occurred.
    e.printStackTrace();

    return "ERROR_IN_CODE";
}