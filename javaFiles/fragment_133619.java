private final static String YES = "Yes";
private final static String NO = "No";
private final static String ON = "On";

//option = yes or no.
//This is for option == Yes. otherOption = Red, Blue, Black, Yellow
public boolean isYes(String option,String otherOption) {
    if (otherOption.equals(YES)){
        if(button.getText().contains(YES)) {
            button.click();
            clickButton(otherOption);
            return button.getText().contains(ON);
        } else if (button.getText().contains(NO)) {
            clickButton(otherOption);
            return button.getText().contains(ON);
        }
    }
    return false;
}