public class SnapOnScrollListener extends RecyclerView.OnScrollListener {

    public enum Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    private SnapHelperExt snapHelperExt;
    private SnapHelper snapHelper;
    private Behavior behavior;
    private OnSnapPositionChangeListener onSnapPositionChangeListener;
    private int snapPosition = RecyclerView.NO_POSITION;


    public SnapOnScrollListener(SnapHelper snapHelper, Behavior behavior, OnSnapPositionChangeListener onSnapPositionChangeListener){
        this.snapHelper = snapHelper;
        this.behavior = behavior;
        this.onSnapPositionChangeListener = onSnapPositionChangeListener;
        this.snapHelperExt = new SnapHelperExt();
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (behavior == Behavior.NOTIFY_ON_SCROLL) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (behavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE
                && newState == RecyclerView.SCROLL_STATE_IDLE) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    private void maybeNotifySnapPositionChange(RecyclerView recyclerView){
        int prevPosition = this.snapHelperExt.getSnapPosition(recyclerView, snapHelper);
        boolean snapPositionIsChanged = (this.snapPosition!=prevPosition);

        if(snapPositionIsChanged){
            onSnapPositionChangeListener.onSnapPositionChange(prevPosition);
            this.snapPosition = prevPosition;
        }
    }
}