InputFilter filter = new InputFilter() {
public CharSequence filter(CharSequence source, int start, int end, 
    Spanned dest, int dstart, int dend)
{
    for (int i = start; i < end; i++) {
        if (!isEnglishOrHebrew(source.charAt(i))) { 
            return "";
        }
    }
    return null; 
}

private boolean isEnglishOrHebrew(char c) {
    . . .
}
}; 

edit.setFilters(new InputFilter[]{filter});