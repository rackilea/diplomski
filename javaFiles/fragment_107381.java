private void handleCharacter(int primaryCode, int[] keyCodes) {
    if (isInputViewShown()) {
        if (mInputView.isShifted()) {
            primaryCode = Character.toUpperCase(primaryCode);
        }
    }
    if (isAlphabet(primaryCode) && mPredictionOn) {
        mComposing.append((char) primaryCode);
        getCurrentInputConnection().setComposingText(mComposing, 1);
        updateShiftKeyState(getCurrentInputEditorInfo());
        updateCandidates();
    }
    else {
        mComposing.append((char) primaryCode);
        getCurrentInputConnection().setComposingText(mComposing, 1);
    }

}