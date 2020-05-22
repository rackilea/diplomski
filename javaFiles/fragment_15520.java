public void addAtom(Display display, Window win, Atom key, Atom value) {

    int maskVal = X11.SubstructureRedirectMask | X11.SubstructureNotifyMask;
    NativeLong mask = new NativeLong(maskVal);

    XClientMessageEvent event = new X11.XClientMessageEvent();
    event.type = X11.ClientMessage;
    event.serial = new NativeLong(0);
    event.send_event = 1;
    event.message_type = key;
    event.window = win;
    event.format = 32;
    event.data.setType(NativeLong[].class);
    event.data.l[0] = new NativeLong(NET_WM_STATE_ADD);
    event.data.l[1] = value;
    event.data.l[2] = new NativeLong(0);
    event.data.l[3] = new NativeLong(0);
    event.data.l[4] = new NativeLong(0);

    X11.XEvent e = new X11.XEvent();
    e.setTypedValue(event);

    x11.XSendEvent(display, x11.XDefaultRootWindow(display), 0, mask, e);
    x11.XFlush(display);

}