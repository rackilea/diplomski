import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomClass {
    String name;
    int num1;
    int num2;
    int num3;

    public CustomClass(String name, int num1, int num2, int num3) {
        super();
        this.name = name;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
}

public class Sample {

    public static void main(String[] args) {
        String str = "[ [\"cd\",5,6,7], [\"rtt\",55,33,12], [\"by65\",87,87,12] ]";
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(str.substring(1));
        List<CustomClass> customList = new ArrayList<CustomClass>();
        while (m.find()) {
            String[] arguments = m.group(1).split(",");
            customList.add(new CustomClass(arguments[0], 
                                            Integer.parseInt(arguments[1]), 
                                            Integer.parseInt(arguments[2]), 
                                            Integer.parseInt(arguments[3])));
        }
    }

}