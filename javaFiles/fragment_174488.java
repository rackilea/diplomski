public class OverrideComboPopup extends BasicComboPopup {

    private JScrollPane sPane;
    public KronosComboPopup(KronosComboBox combo) {
        super(combo);
        setBackground(GUIResources.POPUP_MENU_BACKGROUND);
    }

 public JScrollPane createScroller() {
        sPane = new JScrollPane( list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return sPane;
     }

     //Overrides the getPopupHeightForRowCount to include the height of horizontal bar.
     protected int getPopupHeightForRowCount(int maxRowCount) {
        int currentElementCount = comboBox.getModel().getSize();
        int rowCount = Math.min( maxRowCount, currentElementCount );
        if (rowCount==0) return rowCount;
        int ht = super.getPopupHeightForRowCount(maxRowCount);
        double cWidth = comboBox.getSize().getWidth();
        double vWidth = list.getPreferredScrollableViewportSize().getWidth();
        if (vWidth>cWidth) {
           int barHt = sPane.getHorizontalScrollBar().getHeight();
           //Sets the default height of scroll bar
           if (barHt==0) barHt = 16;
           ht = ht + barHt;
        }
        return ht;
     }


    }