import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^(?!.*(FOR,FGS-(AX|AX2|AXMM|EMP|LV1|MLE))).*$";
final String string = "Anything before, FOR,FGS-AX, some other things FOR, anything you wish after\n"
     + "Anything before, FOR,FGS-AX2, some other things FOR, anything you wish after \n"
     + "Anything before, FOR,FGS-EMP, some other things FOR,  anything you wish after\n"
     + "Anything before, FOR,FGS-AX2, some other things FOR, anything you wish after \n"
     + "Anything before, FOR,FGS-AX2, some other things FOR, anything you wish after \n"
     + "Anything before, FOR,FGS-AXMM, some other things FOR, anything you wish after \n"
     + "Anything before, FOR,FGS-NOTAXMM, some other things FOR, anything you wish after ";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}