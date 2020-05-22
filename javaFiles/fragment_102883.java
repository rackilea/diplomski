private boolean errors() {
    boolean i1 = false;//if no errors, return false
    if (Rone.isChecked()) {
        if (nr1.getText().length() == 0) {
            nr1.setError("");
            i1 = true;//There is at least one error
        } else {
            nr1.setError(null);
        }
    }           
    if (Rtwo.isChecked()) {
        if (nr1.getText().length() == 0) {
            nr1.setError("");
            i1 = true;//there is at least one error
        } else {
            nr1.setError(null);
        }
        if (nr2.getText().length() == 0) {
            nr2.setError("");
            return true;//This is the last thing that can happen, so just return true. There is at least one error, this one
        } else {
            nr2.setError(null);
            return i1;//there could have been an error earlier, so return i1
        }
    }
    return i1;//and if the last box isn't checked, return i1 here
}