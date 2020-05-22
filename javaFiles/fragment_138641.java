public class FormattedInput extends LinearLayout {

    private Context mContext;
    private Field mField;
    private TextView mName;
    private EditText mEntry;
    private Boolean mEnableEvents = true;
    private String mPlaceholderText = "";
    private final static String REPLACE_CHAR = " "; // Replace missing data with blank

    public FormattedInput(Context context, Field field) {
        super(context);

        mContext = context;
        mField = field;

        initialize();
        render(mField);
    }

    private void initialize() {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.field_formatted_input, this);

        // setup fields
        mName = (TextView)findViewById(R.id.name);
        mEntry = (EditText)findViewById(R.id.entry);
        mEntry.setFocusable(true);
        mEntry.setRawInputType(Configuration.KEYBOARD_QWERTY);
        mEntry.addTextChangedListener(
                new MaskedWatcher(mField.getDisplayMask())
        );
    }

    public void render(Field field) {
        mName.setText(mField.getFieldName());

        mPlaceholderText = mField.getPlaceholderText();
        if(Utilities.stringIsBlank(mPlaceholderText)) {
            mPlaceholderText = mField.getDisplayMask();
        }
        mEntry.setHint(mPlaceholderText);
        mEntry.setHintTextColor(Color.GRAY);

        if(!Utilities.stringIsBlank(mField.getValue())) {
            mEnableEvents = false;
            String value =  String.valueOf(mField.getValue());
            if (value.equalsIgnoreCase(mField.getDisplayMask()))
                mEntry.setText(mField.getDisplayMask());
            else {
                String val = fillValueWithMask(value, mField.getDisplayMask());
                mEntry.setText(val);
            }
            mEnableEvents = true;
        }
        else if (!Utilities.stringIsBlank(mField.getDefaultValue())) {
            mEnableEvents = false;
            String val = fillValueWithMask(mField.getDefaultValue(), mField.getDisplayMask());
            mEntry.setText(val);
            mEnableEvents = true;
        }
        else {
            mEnableEvents = false;
            mEntry.setText(null);
            mEnableEvents = true;
        }
    }

    public static String fillValueWithMask(String value, String mask) {
        StringBuffer result = new StringBuffer(mask);
        for (int i = 0; i < value.length() && i <= mask.length()-1 ; i++){
            if (mask.charAt(i) == '#' && value.charAt(i) != ' ' && Character.isDigit(value.charAt(i)))
                result.setCharAt(i,value.charAt(i));
        }
        return result.toString();
    }

    public class MaskedWatcher implements TextWatcher {

        private String mMask;
        String mResult = "";    
        String mPrevResult = "";
        int deletePosition = 0;

        public MaskedWatcher(String mask){
            mMask = mask;
        }

        public void afterTextChanged(Editable s) {

            String value = s.toString();

            // No Change, return - or reset of field
            if (value.equals(mPrevResult) && (!Utilities.stringIsBlank(value) && !Utilities.stringIsBlank(mPrevResult))) {
                return;
            }

            String diff = value;
            // First time in and no value, set value to mask
            if (Utilities.stringIsBlank(mPrevResult) && Utilities.stringIsBlank(value)) {
                mPrevResult = mMask;
                mEntry.setText(mPrevResult);
            }
            // If time, but have value
            else if (Utilities.stringIsBlank(mPrevResult) && !Utilities.stringIsBlank(value)) {
                mPrevResult = value;
                mEntry.setText(mPrevResult);
            }
            // Handle other cases of delete and new value, or no more typing allowed
            else {
                // If the new value is larger or equal than the previous value, we have a new value
                if (value.length() >= mPrevResult.length())
                    diff = Utilities.difference(mPrevResult, value);

                // See if new string is smaller, if so it was a delete.
                if (value.length() < mPrevResult.length()) {
                    mPrevResult = removeCharAt(mPrevResult, deletePosition);
                    // Deleted back to mask, reset
                    if (mPrevResult.equalsIgnoreCase(mMask)) {
                        mPrevResult = "";
                        setFieldValue("");
                        mEntry.setText("");
                        mEntry.setHint(mPlaceholderText);
                        return;
                    }
                    // Otherwise set value
                    else
                        setFieldValue(mPrevResult);
                    mEntry.setText(mPrevResult);
                }
                // A new value was added, add to end
                else if (mPrevResult.indexOf('#') != -1) {
                    mPrevResult = mPrevResult.replaceFirst("#", diff);
                    mEntry.setText(mPrevResult);
                    setFieldValue(mPrevResult);
                }
                // Unallowed change, reset the value back
                else {
                    mEntry.setText(mPrevResult);
                }
            }

            // Move cursor to next spot
            int i = mPrevResult.indexOf('#');
            if (i != -1)
                mEntry.setSelection(i);
            else
                mEntry.setSelection(mPrevResult.length());
        }

        private void setFieldValue(String value) {
            //mEnableEvents = false;
            if(mEnableEvents == false) {
                return;
            }
            // Set the value or do whatever you want to do to save or react to the change
        }

        private String replaceMask(String str) {
            return str.replaceAll("#",REPLACE_CHAR);
        }

        private String removeCharAt(String str, int pos) {
            StringBuilder info = new StringBuilder(str);
            // If the position is a mask character, change it, else ignore the change
            if (mMask.charAt(pos) == '#') {
                info.setCharAt(pos, '#');
                return info.toString();
            }
            else {
                Toast.makeText(mContext, "The mask value can't be deleted, only modifiable portion", Toast.LENGTH_SHORT);
                return str;
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            deletePosition = start;
        }

    }
}