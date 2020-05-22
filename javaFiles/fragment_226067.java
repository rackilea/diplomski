public class So20111214a {
    public static String join(String[] argStrings) {
        if (argStrings == null) {
            return "";
        }
        String ret = "";
        if (argStrings.length > 0) {
            ret = argStrings[0];
        } // if
        for (int i = 1; i<argStrings.length; i++) {
            ret += (argStrings[i] == null) 
                    ? "" 
                    : (argStrings[i].isEmpty() 
                        ? "" 
                        :  ( "," + argStrings[i] ) );
        } // for
        return ret;
    } // join() method

    public static void main(String[] args) {
        String[] grandmasters = {  
            "Emanuel Lasker", 
            "José Raúl Capablanca", 
            "Alexander Alekhine", 
            "Siegbert Tarrasch", 
            "Frank Marshall"  
        };
        String[] s1 = null;
        String[] s2 = {};
        String[] s3 = { "Mikhail Botvinnik" };
        System.out.println(join(s1));
        System.out.println(join(s2));
        System.out.println(join(s3));
        System.out.println(join(grandmasters));
        System.out.println(join(new String[]{"I", "love", "", null, "u!"}));
    } // main() method

    /* output:
    <empty string>
    <empty string>
    Mikhail Botvinnik
    Emanuel Lasker,José Raúl Capablanca,Alexander Alekhine,Siegbert Tarrasch,Frank Marshall
    I,love,u!
    */

} // So20111214a class