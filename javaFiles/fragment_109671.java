for (MouseListener listener : this.getMouseListeners()) {
        this.removeMouseListener(listener);
    }
    for (MouseMotionListener listener : this.getMouseMotionListeners()) {
        this.removeMouseMotionListener(listener);
    }