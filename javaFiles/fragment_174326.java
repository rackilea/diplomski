class Sample {
    public static void main(String args[]){
        System.out.println(addSpaces("AZEOHNUEAOONA",4));
    }
    public static String addSpaces(String str,int n)
    {
        String reg = "(?<=.{" + n + "})(?=(.{"+ (n-1) + "})+$)";
        String rep = "$0 ";
        return str.replaceAll(reg,rep);
    }
}