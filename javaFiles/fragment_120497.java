import java.util.regex.*;

public class test {
    public static void main(String[] args) throws Exception {
        int i = 0,j,k,d,index,value = 0;
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher("x.i9j11k2d1\" index=\"603\" value=\"010\"/>");
        if(m.find()) i=Integer.parseInt(m.group());
        if(m.find()) j=Integer.parseInt(m.group());
        if(m.find()) k=Integer.parseInt(m.group());
        if(m.find()) d=Integer.parseInt(m.group());
        if(m.find()) index=Integer.parseInt(m.group());
        if(m.find()) value=Integer.parseInt(m.group());

        System.out.println("i="+i+" value="+value);
    }
}