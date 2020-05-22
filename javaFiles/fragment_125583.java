if (selectionEnd > selectionStart) {
        Spannable str = bodyText.getText();
        boolean exists = false;

        for (CharacterStyle span : str.getSpans(selectionStart, selectionEnd, CharacterStyle.class)) {
            if (span instanceof BackgroundColorSpan)
                str.removeSpan(span);
            exists = true;
        }
        if (!exists) {
            str.setSpan(new BackgroundColorSpan(Color.YELLOW), selectionStart, selectionEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        bodyText.setSelection(selectionStart, selectionEnd);
    }