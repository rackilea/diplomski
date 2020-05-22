/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emad
 */
import java.awt.BorderLayout;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;

import javax.swing.border.LineBorder;

public class SIMessage extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JButton oui = new JButton("Oui"), btnClose = new JButton(new ImageIcon("images\\logo\\delete.gif")),
            non = new JButton("Non"), annuler = new JButton("Annuler"), ok = new JButton("OK");
    public JLabel lblImgErr = new JLabel(new ImageIcon("images\\logo\\msgErreur.png")),
            lblImgConf = new JLabel(new ImageIcon("images\\logo\\msgQuestion.png")),
            lblImgWarning = new JLabel(new ImageIcon("images\\logo\\msgWarning.png")),
            lblImgInfo = new JLabel(new ImageIcon("images\\logo\\msgInformation.png")),
            lblImgQuestion = new JLabel(new ImageIcon("images\\logo\\msgQuestion.png")),
            lblImgIconApp = new JLabel(new ImageIcon("images\\logo\\clntIco.ico"));
    public JLabel title = new JLabel(), message = new JLabel();

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        // TODO Auto-generated method stub
        Object source = e.getSource();
        if (source == oui || source == ok) {
            this.dispose();
        }
    }

    public enum TypeMessage {
        ERROR_MESSAGE,
        CONFIRMATION_MESSAGE,
        WARNING_MESSAGE,
        INFORMATION_MESSAGE,
        VALIDATION_MESSAGE
    }

    public SIMessage(JFrame parent, String title, TypeMessage type, String message) {
        super(parent, true);
        setUndecorated(true);
        getContentPane().setLayout(new GridLayout(1, 1));

        JPanel mainDgPanel = new JPanel();
        mainDgPanel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        mainDgPanel.setBounds(0, 0, 444, 156);
        getContentPane().add(mainDgPanel);
//                mainDgPanel.setBackground(Color.decode(EcranPrincipal.blueThemeCP));

        JTextArea txtrTextarea = new JTextArea(message);
        txtrTextarea.setRows(2);
        txtrTextarea.setBounds(123, 62, 340, 80);
        txtrTextarea.setFont(new Font("Iskoola Pota", Font.PLAIN, 18));
        txtrTextarea.setEditable(false);
        txtrTextarea.setFocusable(false);
        txtrTextarea.setOpaque(false);
        txtrTextarea.setBorder(null);
        txtrTextarea.setWrapStyleWord(true);
        txtrTextarea.setLineWrap(true);
//                txtrTextarea.setForeground(Color.decode(EcranPrincipal.blueThemeBT));
        mainDgPanel.add(txtrTextarea);

        JPanel panelButtons = new JPanel();
        panelButtons.setBounds(47, 115, 344, 30);
        mainDgPanel.add(panelButtons);

        switch (type) {
            case ERROR_MESSAGE: {
                JLabel lblNewLabel = lblImgErr;
                lblNewLabel.setBounds(10, 69, 79, 14);
                mainDgPanel.add(lblNewLabel);

                JButton btnOk = ok;
                panelButtons.add(btnOk);
                break;
            }
            case CONFIRMATION_MESSAGE: {
                JLabel lblNewLabel = lblImgConf;
                lblNewLabel.setBounds(10, 69, 79, 14);
                mainDgPanel.add(lblNewLabel);

                JButton btnOui = oui;
                panelButtons.add(btnOui);
                break;
            }
            case WARNING_MESSAGE: {
                JLabel lblNewLabel = lblImgWarning;
                lblNewLabel.setBounds(10, 69, 79, 14);
                mainDgPanel.add(lblNewLabel);

                JButton btnOk = ok;
                panelButtons.add(btnOk);
                break;
            }
            case INFORMATION_MESSAGE: {
                JLabel lblNewLabel = lblImgInfo;
                lblNewLabel.setBounds(10, 69, 79, 14);
                mainDgPanel.add(lblNewLabel);

                JButton btnOk = ok;
                panelButtons.add(btnOk);
                break;
            }
            case VALIDATION_MESSAGE: {
                JLabel lblNewLabel = lblImgConf;
                lblNewLabel.setBounds(10, 69, 79, 14);
                mainDgPanel.add(lblNewLabel);

                JButton btnOui = oui;
                panelButtons.add(btnOui);

                JButton btnNon = non;
                panelButtons.add(btnNon);

                JButton btnAnnuler = annuler;
                panelButtons.add(btnAnnuler);

                break;
            }
            default:
        }
        ok.addActionListener(this);
        oui.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 444, 27);
        mainDgPanel.add(panel);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JButton btnCloseDf = btnClose;
        btnCloseDf.setBounds(411, 0, 39, 23);
        panel.add(btnCloseDf);

        JLabel lblIconApp = lblImgIconApp;
        lblIconApp.setBounds(10, 4, 77, 14);
        panel.add(lblIconApp);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setBounds(190, 4, 46, 14);
        panel.add(lblTitle);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SIMessage sm=new SIMessage(null, "Attention", SIMessage.TypeMessage.WARNING_MESSAGE,"You need to change ...");
        System.out.println("hello");
    }
}