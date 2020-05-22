package com.ggl.layout.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ggl.layout.model.LayoutModel;

public class LayoutFrame {

    private ControlPanel controlPanel;

    private DrawingPanel drawingPanel;

    private JFrame frame;

    private LayoutModel model;

    private TextPanel textPanel;

    public LayoutFrame(LayoutModel model) {
        this.model = model;
        createPartControl();
    }

    private void createPartControl() {
        frame = new JFrame();
        frame.setTitle("Swing Layout");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        drawingPanel = new DrawingPanel(model);
        mainPanel.add(drawingPanel);

        textPanel = new TextPanel(model);
        mainPanel.add(textPanel.getScrollPane());

        controlPanel = new ControlPanel(model);
        mainPanel.add(controlPanel.getPanel());

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.getRootPane().setDefaultButton(controlPanel.getSubmitButton());
        frame.setVisible(true);
    }

    private void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

}