package com.anarcist.minemodloaderv1.skin.components;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author anarcist
 */
public class TabButton extends JButton {

    public TabButton() {// initialize

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(true);
        this.setBackground(Color.blue);

    }

    // add your own methods or override JButton methods
    public void setActive(){
       //Add code
       //example: setEnabled(true);
    }
}