lines.addMouseWheelListener(new MouseWheelListener() {
    public void mouseWheelMoved(MouseWheelEvent e) {
        int positiveWheelRotation = Math.abs(e.getWheelRotation());
        Object value = null;
        for(int i=0;i<positiveWheelRotation;i++) {
            if(e.getWheelRotation() > 0) 
                value = lines.getNextValue();
            else if(e.getWheelRotation() < 0)
                value = lines.getPreviousValue();
        }
        if(value != null)
            lines.setValue(value);
    }
});