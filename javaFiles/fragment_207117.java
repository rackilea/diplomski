// in selectAll(EventObject) special case the formatted early
       if (editor instanceof JFormattedTextField) {
           invokeSelectAll(editor);
           return;
       }


        private void invokeSelectAll(final JFormattedTextField editor) {
            // old trick: force to commit, and invoke selectall
            editor.setText(editor.getText());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    editor.selectAll();
                }
            });
        }