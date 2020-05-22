import java.util.ArrayList;
import java.util.List;
public class ReplaceValues{

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("truetruefalsefalsefalse");
        list.add("true=Ja;false=Nein");
        String[] split = list.get(0).split(";");

        for (String string : split) {
          String combination[] = string.split("=");     
          list.set(0, list.get(0).replaceAll(combination[0], combination[1]));
        }

        for(String item:list){
            System.out.println(item);
        }

    }
}