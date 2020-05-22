public void adopt(Window child, Window parent) {
    Display display = x11.XOpenDisplay(null);

    Atom wmState = x11.XInternAtom(display, "_NET_WM_STATE", false);
    Atom wmStateModal = x11.XInternAtom(display, "_NET_WM_STATE_MODAL", false);
    x11.XSetTransientForHint(display, child, parent);
    addAtom(display, child, wmState, wmStateModal);

    x11.XCloseDisplay(display);

}