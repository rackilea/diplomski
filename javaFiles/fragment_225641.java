public class string{
private static final String dCase = "abcdefghij";
private static Random r = new Random();
private static String pass = "";

public static String randomString() { //method
    while (pass.length () != 1){
        int rPick = r.nextInt(4);
        if (rPick == 0){
            int spot = r.nextInt(10);
            pass += dCase.charAt(spot);
        } 
    }
    return pass; //return
}
}