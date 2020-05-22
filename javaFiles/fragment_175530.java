/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    char a[]={'s','k'};
    String s0=new String(a);
    String s1=new String("Amar");
    String s2= "amarnath";
    byte[] b1;
    try{
     b1=s2.getBytes("ASCII");
     for(int i =0;i<s2.length();i++)
     {
        System.out.println(b1[i]);
     }
    }
    catch(UnsupportedEncodingException uee){ //handle the excpetion or at least log it}
}