import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MyClass {
    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();

        String text = "Perhaps far exposed age effects. Now distrusts you her delivered applauded affection out sincerity. As tolerably recommend shameless unfeeling he objection consisted. She although cheerful perceive screened throwing met not eat distance. Viewing hastily or written dearest elderly up weather it as. So direction so sweetness or extremity at daughters. Provided put unpacked now but bringing. Unpleasant astonished an diminution up partiality. Noisy an their of meant. Death means up civil do an offer wound of. Called square an in afraid direct. Resolution diminution conviction so mr at unpleasing simplicity no. No it as breakfast up conveying earnestly immediate principle. Him son disposed produced humoured overcame she bachelor improved. Studied however out wishing but inhabit fortune windows. ";

        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)",
                Pattern.MULTILINE | Pattern.COMMENTS);

        Matcher reMatcher = re.matcher(text);
        while (reMatcher.find()) {
            list.add(reMatcher.group());
        }
        String textDelimted[] = new String[list.size()];
        textDelimted = list.toArray(textDelimted);

        StringBuilder stringB = new StringBuilder(300);

        for (int i = 0; i < textDelimted.length; i++) {
            if(stringB.length() + textDelimted[i].length() < 250) {
                stringB.append(textDelimted[i]);
            } else {
                System.out.println("!#@#$%" +stringB.toString());
                stringB = new StringBuilder(300);
                stringB.append(textDelimted[i]);
            }

        }
        System.out.println("!#@#$%" +stringB.toString());
    }
}