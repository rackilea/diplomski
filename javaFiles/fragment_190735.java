if(TextUtils.isEmpty(Numet0.getText()) ||TextUtils.isEmpty(Numet1.getText())||TextUtils.isEmpty(Numet2.getText())) {
    // show your Toast
    return;
}
// If above condition is not true
// use your parseDouble method to get Double value, because at this point you know that NumetX.getText().toString() won't throw NPE
// update your TextView or any other UI component (No need to show Toast of error here)