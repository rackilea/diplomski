boolean allValid = true;

if (TextUtils.isEmpty(e_Name.getText())) {
    allValid = false;
    // do other stuff
}
if (TextUtils.isEmpty(e_Amount.getText())) {
    allValid = false;
    // do other stuff
}
if (TextUtils.isEmpty(e_Description.getText())) {
    allValid = false;
    // do other stuff
}
// finally do what you want if allValid = false
if (!allValid) {
    // your code
} else {
    // all fields are valid
}