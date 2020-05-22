package com.ggl.layout;

import javax.swing.SwingUtilities;

import com.ggl.layout.model.LayoutModel;
import com.ggl.layout.view.LayoutFrame;

public class LayoutDemo implements Runnable {

    @Override
    public void run() {
        new LayoutFrame(new LayoutModel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LayoutDemo());
    }

}