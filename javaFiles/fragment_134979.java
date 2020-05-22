public class WNDCLASSEX extends com.sun.jna.Structure {
    public int cbSize;
    public int style;
    public WNDPROC lpfnWndProc;
    public int cbClsExtra;
    public int cbWndExtra;
    public HMODULE hInstance;
    public HICON hIcon;
    public HCURSOR hCursor;
    public HBRUSH hbrBackground;
    public String lpszMenuName;
    public String lpszClassName;
    public HICON hIconSm;
    public List getFieldOrder() {
        return Arrays.asList("cbSize","style","lpfnWndProc","cbClsExtra","cbWndExtra","hInstance","hIcon","hCursor","hbrBackground","lpszMenuName","lpszClassName","hIconSm");
    }
}