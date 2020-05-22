public class CleanAndClearEditText extends RelativeLayout {

    private final EditText editText;
    private final Button clearButton;

    public CleanAndClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.clean_and_clear_edit_text, this);
        RelativeLayout rl = (RelativeLayout) getChildAt(0); // consider using a merge tag in R.layout.clean_and_clear_edit_text instead of the parent RelativeLayout
        //clearButton = (Button) findViewById(R.id.cacClearButton);
        clearButton = (Button) rl.getChildAt(1);
        clearButton.setOnClickListener(null);
        //editText = (EditText) findViewById(R.id.cacEditText);
        editText = (EditText) rl.getChildAt(0);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.stateToSave = editText.getText().toString();
        return ss;

    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        editText.setText(ss.stateToSave);
    }

    static class SavedState extends BaseSavedState {
        String stateToSave;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            stateToSave = in.readString();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(stateToSave);
        }

        // required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}