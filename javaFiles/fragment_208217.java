public class FlingView extends WebView {

    public interface FlingListener {
        void onLeftFling();
        void onRightFling();
    }

    private FlingListener mListener;

    public void setFlingListener(FlingListener listener) {
        mListener = listener;
    }

    public void onLeftFling() {
        if (mListener != null) {
            mListener.onLeftFling();
        }
    }

    public void onRightFling() {
        if (mListener != null) {
            mListener.onRightFling();
        }
    }

    ...
}