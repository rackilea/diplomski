JScrollbar a, b, c; // class fields in the listener or an outer class

public void adjustmentValueChanged(AdjustmentEvent e){
    if (a == e.getAdjustable()) {
            // do a something
    } else if ...