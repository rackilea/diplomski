public class SmartPopup extends PopupPanel {

    public void show(int left, int top) {
        setPopupPositionAndShow(new PositionCallback() {
            @Override
            public void setPosition(int offsetWidth, int offsetHeight) {
                int popupLeft = left;
                if ((offsetWidth + left > Window.getClientWidth())
                    && (left - offsetWidth > 0)) {
                    popupLeft = left - offsetWidth;
                }

                int popupTop = top;
                if ((top + offsetHeight > Window.getClientHeight())
                    && (top - offsetHeight > 0)) {
                    popupTop = top - offsetHeight;
                }

                setPopupPosition(popupLeft, popupTop);
            }
        });
    }
}