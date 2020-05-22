import com.jniwrapper.Int;
import com.jniwrapper.Parameter;
import com.jniwrapper.Pointer;
import com.jniwrapper.Structure;
import com.jniwrapper.UInt32;
import windows.WinDef;

public class DWMBlurBehind extends Structure {

    public static final int DWM_BB_ENABLED = 0x1;
    public static final int DWM_BB_BLURREGION = 0x2;
    public static final int DWM_BB_TRANSITIONONMAXIMIZED = 0x4;

    private UInt32 dwFlags;
    private Int enabled;
    private Pointer.Void region;
    private Int transitionOnMazimized;

    public DWMBlurBehind() {

        dwFlags = new UInt32(DWM_BB_ENABLED);
        enabled = new Int(WinDef.TRUE);
        transitionOnMazimized = new Int(WinDef.TRUE);
        region = new Pointer.Void();
        init(new Parameter[]
        {
            dwFlags,
            enabled,
            region,
            transitionOnMazimized
        });
    }

    public long getFlags() {
        return dwFlags.getValue();
    }

}