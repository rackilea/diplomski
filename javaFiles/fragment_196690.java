/* define this inside your dialog class */
public interface Callback {
    void onOkClicked();
    void onCancelClicked();
}

void popupMessage(String title, String message, String pText, String nText, boolean cancelable, Callback callback) {
    ...
        /* positive button clicklistener, for negative button, use callback.onCancelClicked() */
        public void onClick(DialogInterface dialog, int which) {
            callback.onOKClicked();
        }
    ... 
}

/* Using the method */
popupMessage(..., new Callback() {
    void onOKClicked() {
        /* do something when OK was clicked */
    }

    void onCancelClicked() {
        /* do something when Cancel was clicked */
    }
});