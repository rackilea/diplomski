public static List<WindowInfo> getWindows() {
    final List<WindowInfo> inflList = new ArrayList<WindowInfo>();
    final List<Integer> order = new ArrayList<Integer>();
    int top = User32.instance.GetTopWindow(0);
    while (top!=0) {
        order.add(top);
        top = User32.instance.GetWindow(top, User32.GW_HWNDNEXT);
    }
    User32.instance.EnumWindows(new WndEnumProc()
    {
        @Override
        public boolean callback(int hWnd, int lParam)
        {
            if (User32.instance.IsWindowVisible(hWnd)) {
                RECT r = new RECT();
                User32.instance.GetWindowRect(hWnd, r);
                if (r.left>-32000) {     // minimized
                    byte[] buffer = new byte[1024];
                    User32.instance.GetWindowTextA(hWnd, buffer, buffer.length);
                    String title = Native.toString(buffer);
                    inflList.add(new WindowInfo(hWnd, r, title));
                }
            }
            return true;
        }
    }, 0);
    Collections.sort(inflList, new Comparator<WindowInfo>()
            {
        @Override
        public int compare(WindowInfo o1, WindowInfo o2) {
            return order.indexOf(o1.hwnd)-order.indexOf(o2.hwnd);
        }
            });
    return inflList;
}
public static interface WndEnumProc extends StdCallLibrary.StdCallCallback {
    boolean callback (int hWnd, int lParam);
}

public static interface User32 extends StdCallLibrary
{
    final User32 instance = (User32) Native.loadLibrary ("user32", User32.class);
    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class,
               W32APIOptions.DEFAULT_OPTIONS);
    boolean EnumWindows (WndEnumProc wndenumproc, int lParam);
    boolean IsWindowVisible(int hWnd);
    int GetWindowRect(int hWnd, RECT r);
    void GetWindowTextA(int hWnd, byte[] buffer, int buflen);
    int GetTopWindow(int hWnd);
    int GetWindow(int hWnd, int flag);

    HWND FindWindow(String lpClassName, String lpWindowName);

    final int GW_HWNDNEXT = 2;
}