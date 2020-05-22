X11Extended xlib = X11Extended.INSTANCE;
WindowByReference current_ref = new WindowByReference();
Display display = xlib.XOpenDisplay(null);
if (display != null) {
    IntByReference revert_to_return = new IntByReference();
    xlib.XGetInputFocus(display, current_ref, revert_to_return);
    Window current = current_ref.getValue();
    System.out.println(current);
}