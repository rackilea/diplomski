public class CurrencyTextWatcher  implements TextWatcher {
    boolean mEditing;
    Context context;


    public CurrencyTextWatcher() {
        mEditing = false;
    }

    public synchronized void afterTextChanged(Editable s) {

        if(!mEditing) {
            mEditing = true;
            String digits = s.toString().replaceAll("\\D", "");
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            nf.setMinimumFractionDigits(3);

            try{
                String formatted = nf.format(Double.parseDouble(digits)/1000);
                s.replace(0, s.length(), formatted);
            } catch (NumberFormatException nfe) {
                s.clear();
            }
            mEditing = false;
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    public void onTextChanged(CharSequence s, int start, int before, int count) { }

}