import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;

import java.util.Arrays;
import java.util.List;

public class DWM_BLURBEHIND extends Structure {

    public WinDef.DWORD dwFlags;
    public boolean  fEnable;
    public WinDef.HRGN hRgnBlur;
    public boolean  fTransitionOnMaximized;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("dwFlags", "fEnable", "hRgnBlur", "fTransitionOnMaximized");
    }

}