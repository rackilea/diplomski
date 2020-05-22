@Override
public Parcelable onSaveInstanceState() {
    Parcelable superState = super.onSaveInstanceState();
    // Save state if we are forced to
    final boolean freezesText = getFreezesText();
    boolean hasSelection = false;
    int start = -1;
    int end = -1;
    if (mText != null) {
        start = getSelectionStart();
        end = getSelectionEnd();
        if (start >= 0 || end >= 0) {
            // Or save state if there is a selection
            hasSelection = true;
        }
    }
    if (freezesText || hasSelection) {
        SavedState ss = new SavedState(superState);
        if (freezesText) {
            if (mText instanceof Spanned) {
                final Spannable sp = new SpannableStringBuilder(mText);
                if (mEditor != null) {
                    removeMisspelledSpans(sp);
                    sp.removeSpan(mEditor.mSuggestionRangeSpan);
                }
                ss.text = sp;
            } else {
                ss.text = mText.toString();
            }
        }
        if (hasSelection) {
            // XXX Should also save the current scroll position!
            ss.selStart = start;
            ss.selEnd = end;
        }
        if (isFocused() && start >= 0 && end >= 0) {
            ss.frozenWithFocus = true;
        }
        ss.error = getError();
        if (mEditor != null) {
            ss.editorState = mEditor.saveInstanceState();
        }
        return ss;
    }
    return superState;
}