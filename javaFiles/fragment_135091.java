import java.awt.Dimension;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingEg {
    private static void createAndShowUI() {
        JFrame frame = new JFrame("Main JFrame");
        frame.getContentPane().add(new MainGUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}

class MainGUI {
    private static final Dimension MAIN_PANEL_SIZE = new Dimension(450, 300);
    private JPanel mainPanel = new JPanel();
    private JDialog modalDialog;
    private JDialog nonModalDialog;

    public MainGUI() {
        JButton openModalDialogBtn = new JButton("Open Modal Dialog Window");
        openModalDialogBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openModalDialogBtnActionPerformed(e);
            }
        });
        JButton openNonModalDialogBtn = new JButton("Open Non-Modal Dialog Window");
        openNonModalDialogBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openNonModalDialogBtnActionPerformed(e);
            }
        });
        mainPanel.setPreferredSize(MAIN_PANEL_SIZE);
        mainPanel.add(openModalDialogBtn);
        mainPanel.add(openNonModalDialogBtn);
    }

    private void openModalDialogBtnActionPerformed(ActionEvent e) {
        if (modalDialog == null) {
            Window topWindow = SwingUtilities.getWindowAncestor(mainPanel);
            modalDialog = new JDialog(topWindow, "Modal Dialog", ModalityType.APPLICATION_MODAL);
            modalDialog.getContentPane().add(new DialogPanel().getMainPanel());
            modalDialog.pack();
            modalDialog.setLocationRelativeTo(topWindow);
            modalDialog.setVisible(true);
        } else {
            modalDialog.setVisible(true);
        }
    }

    private void openNonModalDialogBtnActionPerformed(ActionEvent e) {
        if (nonModalDialog == null) {
            Window topWindow = SwingUtilities.getWindowAncestor(mainPanel);
            nonModalDialog = new JDialog(topWindow, "Non-Modal Dialog", ModalityType.MODELESS);
            nonModalDialog.getContentPane().add(new DialogPanel().getMainPanel());
            nonModalDialog.pack();
            nonModalDialog.setLocationRelativeTo(topWindow);
            nonModalDialog.setVisible(true);
        } else {
            nonModalDialog.setVisible(true);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

class DialogPanel {
    private static final Dimension DIALOG_SIZE = new Dimension(300, 200);
    private JPanel dialogPanel = new JPanel();

    public DialogPanel() {
        dialogPanel.add(new JLabel("Hello from a dialog", SwingConstants.CENTER));
        dialogPanel.setPreferredSize(DIALOG_SIZE);
    }

    public JPanel getMainPanel() {
        return dialogPanel;
    }
}