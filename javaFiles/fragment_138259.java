import com.sun.jna.Memory;
import com.sun.jna.WString;
public String winGetText(String szTitle) {
   Memory szRetText = new Memory(2 * 256);
   autoItX.AU3_WinGetText(new WString(szTitle), new WString(""), szRetText, 256);
   return szRetText.getString(0, true);
}