@Override
    public void onTextChanged(CharSequence s, int i, int before, int count) {
        // do null check here
        if (etNote.getLayout() != null) {
            int start = etNote.getLayout().getLineStart(0);
            int end = etNote.getLayout().getLineEnd(0);
            String title = etNote.getText().subSequence(start, end).toString();
            etNoteTitle.setText(title);
        }

    }