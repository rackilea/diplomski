private void appbarNew() {

    APPBARDATA data = new APPBARDATA.ByReference();
    data.cbSize.setValue(data.size());
    int WM_USER = 0x0400;
    data.hWnd = hWndGlobal;
    data.uCallbackMessage.setValue(WM_USER + 1);

    UINT_PTR result = Shell32.INSTANCE.SHAppBarMessage(new DWORD(ShellAPI.ABM_NEW), data);
    System.out.println("result: " + result);

}