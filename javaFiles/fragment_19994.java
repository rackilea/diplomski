public class MyEditText extends EditText {

    // ...

    @Override
    public void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);

        // Make sure the text's length is greater than zero.
        // Then, if the cursor is at position zero...
        if (getText().length() > 0 && selStart == 0) {
            // ...move it over to position one.
            setSelection(1, selEnd);
        }
    }
}