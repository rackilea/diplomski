if (!nightPost(timePicker1.getValue().toString(), timePicker4.getValue().toString()) ) {
    return false;
}
if ( teToTime.isAfter(LocalTime.parse("08:30",format)) ) {
    textField4.setStyle("-fx-border-color: red");
    return false;
}
textField4.setStyle("");
if ( !(getDifference(timeKA, timeKB) < 121 && getDifference(timeKA, timeKB) > 59) ) {
    timePicker3.setStyle("-fx-border-color: red");
    return false;
}
timePicker3.setStyle("");
if ( !range(timePicker1.getValue().toString(), timePicker2.getValue().toString(), 
            timePicker3.getValue().toString(), timePicker4.getValue().toString()) ) 
{
    timePicker2.setStyle("-fx-border-color: orange");
    return false;
}
timePicker2.setStyle("");
timePicker3.setStyle("");
if ( !increaseTxt.isBefore(LocalTime.parse("11:01",format)) ) {
    textField5.setStyle("-fx-border-color: red");
    return false;
}
textField5.setStyle("");
return true;