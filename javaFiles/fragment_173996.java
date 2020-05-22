public static class DefWindowProc implements WinUser.WindowProc {
    @Override
    public LRESULT callback(WinDef.HWND hWnd, int uMsg, WinDef.WPARAM wParam, WinDef.LPARAM lParam) {
        return User32.INSTANCE.DefWindowProc(hWnd, uMsg, wParam, lParam);
    }
}