private void openFile(final File aFile) {
        String nullChk = et.getText().toString();
        exists = true;

        if (!changed || nullChk.matches("")) {
            try {
                currentFile = aFile;
                et.setText(new Scanner(currentFile).useDelimiter("\\Z").next());
                lineNumbers.setText("");
                lines = 1;

                for (int i = 1; i < et.getLineCount(); i++) {
                    lineNumbers.append(lines + "\n");
                    lines++;
            ...
}

et.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    lines++;
                    lineNumbers.append(lines + "\n");
                }
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_DEL)) {
                    lineNumbers.setText("");
                    lines = 0;

                    for (int i = 1; i < et.getLineCount(); i++) {
                        lines++;
                        lineNumbers.append(lines + "\n");
                    }
                }
                return false;
            }
        });