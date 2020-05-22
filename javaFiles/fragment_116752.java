import static java.util.regex.*;

public void PostCodeSearch() {
    ReadingFromAFile();
    String StrPstCd = PstCd.getText();
    Pattern pattern = Pattern.compile("^\\S*" + StrPstCd + "\\S*$");
    for(int i = 0; i<twod.length; ++i) {
        Matcher matcher = pattern.matcher(twod[i][3]);
        if (matcher.matches()) {
            text.append("Price = " + twod[i][1] + " " + "Date of Sale: " + twod[i][2] + " " + "Postcode: " + twod[i][3] + "\n");
            }
        }
    }