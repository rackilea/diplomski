void Update_Layout() {
        Main_Panel.setPreferredSize(new Dimension(Command_Info_Panel_Width, Item_Count * (Command_Info_Panel_Height + 2) + 36));
        if (Item_Count * (Command_Info_Panel_Height + 2) + 40 < Max_H) {
            Scroll_Pane.setPreferredSize(new Dimension(W - 2, Item_Count * (Command_Info_Panel_Height + 2) + 40));
        } else {
            Scroll_Pane.setPreferredSize(new Dimension(W - 2, Max_H));
        }

        Scroll_Pane.revalidate();
        Scroll_Pane.repaint();
        revalidate();
        repaint();
        Main_Panel.revalidate();
        Main_Panel.repaint();

        /*
  Online advice of how to adjudt the Scroll_Pane : https://robbamforth.wordpress.com/2015/06/24/java-how-to-scroll-to-a-particular-component-in-jscrollpane-and-gain-focus/
    JPanel comp=(JPanel)Main_Panel.getComponent(Main_Panel.getComponentCount()-1);
//  vertical.setValue(Main_Panel.getParent().getLocation().y+(Main_Panel.getLocation().y+50));
//  JComponent comp=Main_Panel;
//  vertical.setValue(comp.getParent().getLocation().y+(comp.getLocation().y+50));
  vertical.setValue(250);
  comp.requestFocus();
Out(comp.toString());
    vertical.repaint();
    vertical.revalidate();
         */
        if (Item_Count * (Command_Info_Panel_Height + 2) + 40 < Max_H) {
            frame.setPreferredSize(new Dimension(W + 17, Item_Count * (Command_Info_Panel_Height + 2) + 122 + Command_Info_Panel_Height + Info_TextArea_H));
        } else {
            frame.setPreferredSize(new Dimension(W + 17, Max_H + 82 + Command_Info_Panel_Height + Info_TextArea_H));
        }

        //HERE!
        frame.pack();
        JScrollBar vertical = Scroll_Pane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        Out(" vertical.getMaximum() = " + vertical.getMaximum() + "  vertical.getMinimum() = " + vertical.getMinimum());
        //frame.pack();//in case you want to pack again, not needed for your fix.
        frame.revalidate();
        frame.repaint();
    }