private static final MyUser32 WIN_INSTANCE = MyUser32.INSTANCE;
private static final int SWP_NOMOVE = 2;
private static final int WM_KEYDOWN = 256;
private static final int WM_WINDOWPOSCHANGING = 70;
private static final int WM_IME_ENDCOMPOSITION = 270;
private static final int WM_IME_STARTCOMPOSITION = 269;
private WinDef.HWND hwndMain;
private BaseTSD.LONG_PTR prevWndProc;

// Keep references to these listeners so they don't get garbage-collected.
private WindowsCallbackListener mainListener;
private WindowsCallbackListener imeListener;

private boolean imeComposing;
private WinDef.HWND imeWindow;

public static class WindowPosition extends Structure {
    public WinDef.HWND hwnd;
    public WinDef.HWND hwndInsertAfter;
    public int x;
    public int y;
    public int cx;
    public int cy;
    public int flags;

    public WindowPosition(Pointer p) {
        super(p);
    }

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("hwnd", "hwndInsertAfter", "x", "y", "cx", "cy", "flags");
    }
}

private interface MyUser32 extends User32 {
    MyUser32 INSTANCE = (MyUser32) Native.loadLibrary("user32", MyUser32.class, W32APIOptions.DEFAULT_OPTIONS);
    int CallWindowProc(BaseTSD.LONG_PTR prevWndProc, int hWnd, int uMsg, int uParam, int lParam);
    int SetWindowLong(HWND hwnd, int nIndex, BaseTSD.LONG_PTR listener) throws LastErrorException;
    int SetWindowLong(HWND hwnd, int nIndex, WindowsCallbackListener listener) throws LastErrorException;
}

private interface WindowsCallbackListener extends Callback, StdCall {
    int callback(int hWnd, int Msg, int wParam, int lParam);
}