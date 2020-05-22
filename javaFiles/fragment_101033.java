class CustomVerticalFieldManger extends VerticalFieldManager {
        private final int VERTICAL_GAP = 30;

        protected void sublayout(int maxWidth, int maxHeight) {
            int nFields = getFieldCount(), height = 0, xPosition, yPosition = 0;
            Field f;
            for (int i = 0; i < nFields; i++) {
                f = getField(i);
                layoutChild(f, maxWidth, maxHeight);
                height += f.getHeight();
                if (i != 0) {
                    height += VERTICAL_GAP;
                }
            }
            for (int i = 0; i < nFields; i++) {
                f = getField(i);
                xPosition = (maxWidth - f.getWidth()) / 2;
                setPositionChild(f, xPosition, yPosition);
                yPosition += f.getHeight();
                if (i != nFields - 1) {
                    yPosition += VERTICAL_GAP;
                }
            }
            setExtent(maxWidth, height);
        }
    }