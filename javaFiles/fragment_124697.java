public class Test {
    String s = new String((byte) 42);
}
$ javac Test.java 
Test.java:2: error: no suitable constructor found for String(byte)
    String s = new String((byte) 42);
               ^
    constructor String.String(String) is not applicable
      (argument mismatch; byte cannot be converted to String)
    constructor String.String(char[]) is not applicable
      (argument mismatch; byte cannot be converted to char[])
    constructor String.String(byte[]) is not applicable                                                                                                       
      (argument mismatch; byte cannot be converted to byte[])                                                                                                 
    constructor String.String(StringBuffer) is not applicable                                                                                                 
      (argument mismatch; byte cannot be converted to StringBuffer)                                                                                           
    constructor String.String(StringBuilder) is not applicable                                                                                                
      (argument mismatch; byte cannot be converted to StringBuilder)                                                                                          
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output                                                                   
1 error                                                                       
$