public class MyEditText extends EditText {

    public MyEditText(Context context) {
        super(context);

        // Set the EditText's input filter.
        setFilters(new InputFilter[] { new InputFilter {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                        Spanned dest, int dstart, int dend) {
                // If the currency symbol is about to be replaced...
                if (dstart == 0)
                    // Add the currency symbol to the front of the source.
                    return currencySymbol + source;
                // else
                    // Return null to indicate that the change is okay.
                    return null;
            } 
        }});
    }

    // ...
}