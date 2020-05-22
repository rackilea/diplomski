spinner = new JSpinner(new SpinnerModel() {
    private ChangeListener l;

    @Override
    public void setValue(Object value) {
        ...

        if(l != null) {
            l.stateChanged(new ChangeEvent(this));
        }
    }

    ...

    @Override
    public void addChangeListener(ChangeListener l) {
        this.l = l;
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        if(this.l == l) {
            this.l = null;
        }
    }
});