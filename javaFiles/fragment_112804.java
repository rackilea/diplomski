public void setArabic(JTextField txt) {
    txt.getInputContext().selectInputMethod(new Locale("ar", "SA"));
    txt.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);    
}

public void setEnglish(JTextField txt) {
    txt.getInputContext().selectInputMethod(new Locale("en", "US"));
    txt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);    
}