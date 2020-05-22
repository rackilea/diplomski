public class OtherClass { // Presenter

    private Model mData; // Model

    public interface OnTextChangeListener {
        void onTextChanged(String text); // Callback to View
    }

    public Model getData() {
        return mData;
    }

    OnTextChangeListener listener; // Callback to View

    // other code
    mData.setName("some other string"); // Update the model
    if (listener != null) {
        listener.onTextChanged(mData.getName()); // Present the data
    }
}