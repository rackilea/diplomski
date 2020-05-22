public AuthenticationWindowController(Frame parent)
{
    _ui = new AuthenticationWindow(parent);
    _parent = parent;
    registerListener();
    _ui.show();
}