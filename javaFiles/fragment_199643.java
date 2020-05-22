interface AfterTextChangedTextWatcher extends TextWatcher
{
    @Override
    public default void beforeTextChanged(CharSequence s, int start, int count, int after) {}


    @Override
    public default void onTextChanged(CharSequence s, int start, int before, int count) {}

}