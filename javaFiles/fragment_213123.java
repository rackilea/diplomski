import com.google.common.base.CaseFormat;


public class StackOverflow25680258 {

    public static void main(String[] args) {
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "input_in_snake_case")); 
    }

}