import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValuesListParse {

  public static void main(String[] args) {

    String stmt = " INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz),(aaa,'bb),(b',ccc),(aaa,bbb,ccc); ";
    System.out.printf("%s\n", stmt);

    //extract values list
    stmt = stmt.split("(?i)\\s+values\\s*\\(|\\);")[1];
    System.out.printf("values list: %s\n", stmt);

    // identify pattern between '' (char literal) and replace it with another pattern: the 2nd group is what we want 
    /* UPDATE modified regexp from ('.*)(\\)\\,\\()(.*') to ('\\w*)(\\)\\,\\()+(\\w*') to manage multiple literals containig the pattern */
    Matcher m = Pattern.compile("('\\w*)(\\)\\,\\()+(\\w*')").matcher(stmt);
    while (m.find()) {
        stmt = stmt.substring(0, m.start(2)) + "###" + stmt.substring(m.end(2), stmt.length());
        System.out.printf("values list with pattern subst inside char literal: %s\n", stmt);
    }

    // split multiple values
    String[] multiValues = stmt.split("\\)\\,\\(");

    // adjust char literal
    for (int i = 0; i < multiValues.length ; i++) {
        multiValues[i] = multiValues[i].replaceAll("###", "),(");
    }

    System.out.println(Arrays.toString(multiValues));

   }
}