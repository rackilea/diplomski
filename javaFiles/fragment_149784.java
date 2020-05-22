public void setBeginAMPM( String ampm ) {
    if(ampm.equals(new I18NStringFactory().getString("Calendar", _locale , "default.time.am" ))) {
        _beginAMPM = "AM";
    }
    else if(ampm.equals(new I18NStringFactory().getString("Calendar", _locale , "default.time.pm" ))) {
        _beginAMPM = "PM";
    }
    else{
        _beginAMPM = ampm;
    }
}


public void setEndAMPM( String ampm ) {
    if(ampm.equals(new I18NStringFactory().getString("Calendar", _locale , "default.time.am" ))) {
        _endAMPM = "AM";
    }
    else if(ampm.equals(new I18NStringFactory().getString("Calendar", _locale , "default.time.pm" ))) {
        _endAMPM = "PM";
    }
    else{
        _endAMPM = ampm;
    }
}