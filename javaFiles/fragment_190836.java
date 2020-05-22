@Override public void onStartInput(EditorInfo attribute, boolean restarting) {
    super.onStartInput(attribute, restarting);

    ...

    // We are now going to initialize our state based on the type of
    // text being edited.
    switch (attribute.inputType & InputType.TYPE_MASK_CLASS) {
        case InputType.TYPE_CLASS_NUMBER:
        case InputType.TYPE_CLASS_DATETIME:
            mCurKeyboard = mSymbolsKeyboard;
            break;

        case InputType.TYPE_CLASS_PHONE:
            mCurKeyboard = mSymbolsKeyboard;
            break;

        case InputType.TYPE_CLASS_TEXT:
            mCurKeyboard = mQwertyKeyboard;
            ...
            break;

        default:
            // For all unknown input types, default to the alphabetic
            // keyboard with no special features.
            mCurKeyboard = mQwertyKeyboard;
    }

}

@Override public void onStartInputView(EditorInfo attribute, boolean restarting) {
    super.onStartInputView(attribute, restarting);
    // Apply the selected keyboard to the input view.
    setLatinKeyboard(mCurKeyboard);
    ...
}

private void setLatinKeyboard(LatinKeyboard nextKeyboard) {
    final boolean shouldSupportLanguageSwitchKey =
            mInputMethodManager.shouldOfferSwitchingToNextInputMethod(getToken());
    nextKeyboard.setLanguageSwitchKeyVisibility(shouldSupportLanguageSwitchKey);
    mInputView.setKeyboard(nextKeyboard);
}