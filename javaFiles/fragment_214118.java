import com.sun.jna.Library;
import com.sun.jna.Native; 
import com.sun.jna.platform.win32.Kernel32;

// JNA infrastructure import libs.Kernel32; 
// Proxy interface for kernel32.dll 

public class JnaTests {

private static Kernel32 kernel32 = (Kernel32)                    
Native.loadLibrary ("kernel32",   Kernel32.class);

private static void toMorseCode(String letter) throws Exception { 
 for (byte b : letter.getBytes()) { 
  kernel32.Beep(1200, ((b == '.') ? 50 : 150)); 
  Thread.sleep(50); 
 }  
} 

public static void main(String[] args) throws Exception { 
 String helloWorld[][] = { {"....", ".", ".-..", ".-..", "---"}, 
 {".--",  "---", ".-.", ".-..", "-.."}}; 

for (String word[] : helloWorld) { 
 for (String letter : word) { 
  toMorseCode(letter); 
  Thread.sleep(150); 
 } 
 Thread.sleep(350); 
}