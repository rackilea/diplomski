private void setLatinKeyboard(LatinKeyboard nextKeyboard) {
    final boolean shouldSupportLanguageSwitchKey =
            mInputMethodManager.shouldOfferSwitchingToNextInputMethod(getToken());
    nextKeyboard.setLanguageSwitchKeyVisibility(shouldSupportLanguageSwitchKey);
    mInputView.setKeyboard(nextKeyboard);
}