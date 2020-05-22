int[] events = { KeyEvent.VK_0, KeyEvent.VK_1 ... KeyEvent.VK_9, KeyEvent.VK_NUMPAD0 ... KeyEvent.VK_NUMPAD9 };
JMenuItem[] items = {item1,item2 ... item20};
for(int i = 0;i < events.length && i < items.length;i++){
    items[i].setAccelerator(KeyStroke.getKeyStroke(
                events[i], 
                Event.CTRL_MASK));
}