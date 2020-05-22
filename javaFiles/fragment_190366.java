package com.example;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example  {

    public Example() {

        JPanel a = new JPanel();
        a.setBackground(Color.RED);
        a.setPreferredSize(new Dimension(128, 128));

        JPanel b = new JPanel();
        b.setBackground(Color.BLUE);
        b.setPreferredSize(new Dimension(128, 128));

        JPanel panel = new JPanel(new Sly493LayoutManager());
        panel.add(a, Sly493LayoutManager.LEFT);
        panel.add(b, Sly493LayoutManager.CENTERED);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }

    private static class Sly493LayoutManager implements LayoutManager2 {

        public static final Integer LEFT = 0;

        public static final Integer CENTERED = 1;

        private Component leftComponent;

        private Component centeredComponent;

        @Override
        public void addLayoutComponent(String name, Component comp) { }

        @Override
        public void removeLayoutComponent(Component comp) { 
            if (leftComponent == comp) {
                leftComponent = null;
            } else if (centeredComponent == comp) {
                centeredComponent = null;
            }           
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Dimension d = new Dimension();
            for (Component c : parent.getComponents()) {
                //wide enough to stack the left and center components horizontally without overlap
                d.width += c.getPreferredSize().width;
                //tall enough to fit the tallest component
                d.height = Math.max(d.height, c.getPreferredSize().height);
            }
            return d;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {     
            //in this method we will:
            //1) position the left component on the left edge of the parent and center it vertically
            //2) position the center component in the center of the parent (as long as it would not overlap
            //the left component) and center it vertically

            int leftComponentWidth = leftComponent.getPreferredSize().width;
            int leftComponentHeight = leftComponent.getPreferredSize().height;
            int centeredComponentWidth = centeredComponent.getPreferredSize().width;
            int centeredComponentHeight = centeredComponent.getPreferredSize().height;

            leftComponent.setBounds(0, (parent.getHeight() - leftComponentHeight) / 2, leftComponentWidth, leftComponentHeight);
            int leftComponentRightEdge = leftComponent.getX() + leftComponent.getWidth();
            int centerComponentLeftEdge = (parent.getWidth() - centeredComponentWidth) / 2;
            int centerComponentTopEdge = (parent.getHeight() - centeredComponentHeight) / 2;        

            if (leftComponentRightEdge >= centerComponentLeftEdge) {
                //Center component will "do its best" to remain in the center
                //but it will not do so if it would cause it to overlap the left component
                centerComponentLeftEdge = leftComponentRightEdge;
            }

            centeredComponent.setBounds(centerComponentLeftEdge, 
                    centerComponentTopEdge, 
                    centeredComponentWidth, 
                    centeredComponentHeight);
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (LEFT.equals(constraints)) {
                if (leftComponent != null) {
                    throw new IllegalStateException("A left component has already been assigned to this layout.");
                }
                leftComponent = comp;
            } else if (CENTERED.equals(constraints)) {
                if (centeredComponent != null) {
                    throw new IllegalStateException("A centered component has already been assigned to this layout.");
                }
                centeredComponent = comp;
            } else {
                throw new IllegalStateException("Unexpected constraints '" + constraints + "'.");
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0;
        }

        @Override
        public void invalidateLayout(Container target) {

        }       
    }
}