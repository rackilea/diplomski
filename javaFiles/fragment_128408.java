public class MyBoundedRangeModel extends DefaultBoundedRangeModel {

    private boolean updatesAllowed;

    public void setUpdatesAllowed(boolean updatesAllowed) {
        this.updatesAllowed = updatesAllowed;
    }

    public boolean isUpdatesAllowed() {
        return updatesAllowed;
    }

    @Override
    public void setMinimum(int n) {
        setUpdatesAllowed(true);
        super.setMinimum(n);
        setUpdatesAllowed(false);
    }

    @Override
    public void setMaximum(int n) {
        setUpdatesAllowed(true);
        super.setMaximum(n);
        setUpdatesAllowed(false);
    }

    @Override
    public void setExtent(int n) {
        setUpdatesAllowed(true);
        super.setExtent(n);
        setUpdatesAllowed(false);
    }

    @Override
    public void setValue(int n) {
        super.setValue(n);
    }

    @Override
    public void setValueIsAdjusting(boolean b) {
        setUpdatesAllowed(true);
        super.setValueIsAdjusting(b);
        setUpdatesAllowed(false);
    }

    @Override
    public void setRangeProperties(int newValue, int newExtent, int newMin, int newMax, boolean adjusting) {        
        if (isUpdatesAllowed()) {
            super.setRangeProperties(newValue, newExtent, newMin, newMax, adjusting);
        }
    }

}