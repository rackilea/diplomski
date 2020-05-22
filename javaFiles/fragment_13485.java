public static boolean Address(EditText etAddress, String sAddress) {
    //changed your pattern text according to your requirements
    Pattern ps = Pattern.compile("[-0-9A-Za-z.,/ ]+");    
    Matcher ms = ps.matcher(etAddress.getText().toString());    
    boolean bs = ms.matches();
    if (bs == false) {    
        etAddress.setError("error");
        bs = true;

    } else {
        etAddress.setError(null);
        bs = false;
    }
    return bs;
}