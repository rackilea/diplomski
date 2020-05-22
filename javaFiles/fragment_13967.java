String msg = "You have selected:";
if (DCB1.isChecked()) {
    msg += "\n    DCB1"; //or get the disease name
}
if (DCB2.isChecked()) {
    msg += "\n    DCB2"; //or get the disease name
}
if (DCB3.isChecked()) {
    msg += "\n    DCB3"; //or get the disease name
}
if (DCB4.isChecked()) {
    msg += "\n    DCB4"; //or get the disease name
}
showMessage(msg);