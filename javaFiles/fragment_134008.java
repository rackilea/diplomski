public class StringTest 
{  

    public static void main(String[] args) 
    {  
        String str = "02-EST-WHATEVER-099-00.dwg";

        String newStr = str.replaceAll("([^-_\\.]+-[^-_\\.]+-[^-_\\.]+-[^-_\\.]+-)[^-_\\.]+(\\.[^-_\\.]+)", "$1$2");

        String regexRemoveRev = "([^-_\\.]+-[^-_\\.]+-[^-_\\.]+-[^-_\\.]+-)[^-_\\.]+(\\.[^-_\\.]+)";

        String newStr1 = str.replaceAll(regexRemoveRev, "$1$2");

        System.out.println("newStr: "+newStr);
        System.out.println("regexRemoveRev: "+regexRemoveRev);
        System.out.println("newStr: "+newStr1);

    }  
}