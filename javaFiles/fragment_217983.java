import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonArrowKeyNavigation {
    private ButtonArrowKeyNavigation() {}

    public static void install() {
        UIManager.addAuxiliaryLookAndFeel(lookAndFeel);
    }

    private static final LookAndFeel lookAndFeel = new LookAndFeel() {
        private final UIDefaults defaults = new UIDefaults() {
            @Override
            public javax.swing.plaf.ComponentUI getUI(JComponent c) {
                if (c instanceof AbstractButton && !(c instanceof JMenuItem)) {
                    if (c.getClientProperty(this) == null) {
                        c.putClientProperty(this, Boolean.TRUE);
                        configure(c);
                    }
                }
                return null;
            }
        };
        @Override public UIDefaults getDefaults() { return defaults; };
        @Override public String getID() { return "ButtonArrowKeyNavigation"; }
        @Override public String getName() { return getID(); }
        @Override public String getDescription() { return getID(); }
        @Override public boolean isNativeLookAndFeel() { return false; }
        @Override public boolean isSupportedLookAndFeel() { return true; }
    };

    private static void configure(JComponent c) {
        InputMap im = c.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = c.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,  0), "focusPreviousButton");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,    0), "focusPreviousButton");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "focusNextButton");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,  0), "focusNextButton");
        am.put("focusPreviousButton", focusPreviousButton);
        am.put("focusNextButton",     focusNextButton);
    }

    private static final Action focusPreviousButton = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            move((AbstractButton)e.getSource(), -1);
        }
    };

    private static final Action focusNextButton = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            move((AbstractButton)e.getSource(), +1);
        }
    };

    private static void move(AbstractButton ab, int direction) {
        Container focusRoot = ab.getFocusCycleRootAncestor();
        FocusTraversalPolicy focusPolicy = focusRoot.getFocusTraversalPolicy();
        Component toFocus = ab, loop = null;
        for (;;) {
            toFocus = direction > 0
                ? focusPolicy.getComponentAfter(focusRoot, toFocus)
                : focusPolicy.getComponentBefore(focusRoot, toFocus);
            if (toFocus instanceof AbstractButton) break;
            if (toFocus == null) return;
            // infinite loop protection; should not be necessary, but just in
            // case all buttons are somehow unfocusable at the moment this
            // method is called:
            if (loop == null) loop = toFocus; else if (loop == toFocus) return;
        }
        if (toFocus.requestFocusInWindow()) {
            if (toFocus instanceof JRadioButton) {
                ((JRadioButton)toFocus).setSelected(true);
            }
        }
    }
}