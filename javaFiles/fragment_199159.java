ContextMenuSkin skin = (ContextMenuSkin) contextMenu.getSkin();
Node up = skin.getNode().lookup(".menu-up-arrow");
Node down = skin.getNode().lookup(".menu-down-arrow");
MouseEvent enteredEvent = new MouseEvent(MouseEvent.MOUSE_ENTERED, ...); // the remaining parameters
if (shouldScrollUp) {
    up.fireEvent(enteredEvent);
} else {
    down.fireEvent(enteredEvent);
}
// consume the event after scroll is over