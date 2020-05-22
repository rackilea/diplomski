import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.text.MessageFormat;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = createFrame();

        JMenuItem foregroundMenuItem = createMenuItem(frame, "getForeground", "Foreground Color");
        JMenuItem backgroundMenuItem = createMenuItem(frame, "getBackground", "Background Color");

        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(foregroundMenuItem);
        popupMenu.add(backgroundMenuItem);

        PopUpListener popUpListener = new PopUpListener(popupMenu);
        frame.addMouseListener(popUpListener);

        frame.setVisible(true);
    }

    private static JMenuItem createMenuItem(Object invocationTarget, String methodName, String actionName) {
        MethodInvocationAction methodInvocationAction = new MethodInvocationAction(invocationTarget, methodName);
        methodInvocationAction.putValue(Action.NAME, actionName);

        JMenuItem menuItem = new JMenuItem(methodInvocationAction);
        return menuItem;
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

}

class MethodInvocationAction extends AbstractAction {

    private Object targetObj;
    private Method targetMethod;

    private boolean keyboardSensitive;

    public MethodInvocationAction(Object targetObj, String methodName) {
        this.targetObj = targetObj;
        try {
            targetMethod = targetObj.getClass().getMethod(methodName);
        } catch (NoSuchMethodException | SecurityException e) {
            String msg = MessageFormat.format("{0} does not have a method named {1}", targetObj, methodName);
            throw new RuntimeException(msg, e);
        }
    }

    public boolean isKeyboardSensitive() {
        return keyboardSensitive;
    }

    public void setKeyboardSensitive(boolean keyboardSensitive) {
        this.keyboardSensitive = keyboardSensitive;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if ((event.getModifiers() != 0) || isKeyboardSensitive()) {
            performAction(event);
        }
    }

    public void performAction(ActionEvent e) {
        try {
            Object invoke = targetMethod.invoke(targetObj);
            JOptionPane.showMessageDialog(null, invoke);
        } catch (Exception exception) {
            showException(exception);
        }
    }

    private void showException(Exception e1) {
        StringWriter exceptionStackTraceWriter = new StringWriter();
        e1.printStackTrace(new PrintWriter(exceptionStackTraceWriter));
        String exceptionStackTrace = exceptionStackTraceWriter.toString();

        JTextArea exceptionStackTraceTextComponent = new JTextArea();
        exceptionStackTraceTextComponent.setText(exceptionStackTrace);

        JScrollPane scrollPane = new JScrollPane(exceptionStackTraceTextComponent);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        JOptionPane.showMessageDialog(null, scrollPane, e1.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
    }
}

class PopUpListener extends MouseAdapter {
    private JPopupMenu menu;

    public PopUpListener(JPopupMenu menu) {
        this.menu = menu;
    }

    public void mousePressed(MouseEvent event) {
        handlePopupEvent(event);
    }

    public void mouseReleased(MouseEvent event) {
        handlePopupEvent(event);
    }

    private void handlePopupEvent(MouseEvent event){
        if (event.isPopupTrigger()) {
            menu.show(event.getComponent(), event.getX(), event.getY());
        }
    }

}