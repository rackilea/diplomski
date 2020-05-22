public class Bus {
    ...
    boolean isExpanded;
    boolean isShowProgress;

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
    }

    public boolean isShowProgress() {
        return this.isShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.isShowProgress = showProgress;
    }
}