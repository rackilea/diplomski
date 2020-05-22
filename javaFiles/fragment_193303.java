import java.io.*;

public class sample2

{  

    public native void callMethod(sample2 s);  

    int val=7;  

    String name="Siva";  

    public static void main(String args[])  

    {  

        System.loadLibrary("sample2");  

        sample2 s = new sample2();  
        s.callMethod(s);  
    }  

}