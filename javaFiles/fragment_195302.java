import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

public interface Shlwapi extends StdCallLibrary {

    Shlwapi INSTANCE = Native.load("Shlwapi", Shlwapi.class);

    int StrCmpLogicalW(WString psz1, WString psz2);
}