package trimmed.stackoverflow.example;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class Helper_Swing {

private static Helper_Swing instance;

private Helper_Swing() {
    instance = this;
}

public static Helper_Swing getInstance() {
    return instance == null ? new Helper_Swing() : instance;
}

private static class J42WindowAdapter extends WindowAdapter {

    final private Window  window;
    final private JDialog dialog;
    private Color         colorBG = null;
    private float         opacity = 0.0f;

    private J42WindowAdapter(final Window window, final JDialog dialog) {
        super();
        this.window = window;
        this.dialog = dialog;
        this.colorBG = window.getBackground();
        this.opacity = window.getOpacity();
    }

    @Override
    public void windowIconified(final WindowEvent e) {
        colorBG = dialog.getBackground();
        opacity = dialog.getOpacity();
        dialog.setOpacity(1.0f);  // Must call 1st
        dialog.setBackground(Color.BLACK); // Must call 2nd
    }

    @Override
    public void windowDeiconified(final WindowEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog.setBackground(colorBG);
                dialog.setOpacity(opacity);
                dialog.setVisible(true);
                dialog.repaint();
            }
        });
    }
}

public void bugFix_transparentJDialog(final Window parentWindow, JDialog childWindow) {
    if (parentWindow != null && childWindow != null && childWindow.isUndecorated()) {
        final WindowListener[] listeners = parentWindow.getWindowListeners();
        for (int x = 0; x != listeners.length; x++) {
            if (listeners[x] instanceof J42WindowAdapter) {
                final J42WindowAdapter adapter = (J42WindowAdapter) listeners[x];
                if (adapter.window == parentWindow && adapter.dialog == childWindow) {
                    childWindow = null;
                    break;
                }
            }
        }
        if (childWindow != null) {
            parentWindow.addWindowListener(new J42WindowAdapter(parentWindow, childWindow));
        }
    }
}

}