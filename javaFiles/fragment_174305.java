public interface OnCustomActionListener {
    // you can remove the button as parameter if you do not care which button the action came from 
    void onCustomAction(CustomButton button);
}

public class CustomButtom extends Button {
    OnCustomActionListener onCustomActionListener;

    public void setOnCustomActionListener(OnCustomActionListener listener) {
        this.onCustomActionListener = listener;
    }

    /* Creator like in your question mentioned */

    private boolean executeCallback() {
        if (this.onCustomActionListener != null) {
            this.onCustomActionListener.onCustomAction(this);
        }
    }
}