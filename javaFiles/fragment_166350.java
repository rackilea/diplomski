public class MouseEvt {
    public static void main(String[] args) {
        MouseEvent event = new MouseEvent(new JPanel(), 1, System
                .currentTimeMillis(), InputEvent.CTRL_DOWN_MASK
                | InputEvent.ALT_DOWN_MASK, 1, 1, 0, false);

        System.out.printf("%d - %d%n", InputEvent.CTRL_DOWN_MASK 
            | InputEvent.ALT_DOWN_MASK,
            event.getModifiersEx());
    }
}