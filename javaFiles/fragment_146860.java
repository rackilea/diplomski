private void jTextField1MouseDragged(java.awt.event.MouseEvent evt) {
        Highlight[] h = jTextField1.getHighlighter().getHighlights();
        if (h != null && h.length > 0) {
            jLabel2.setText(
                    "Selected text: " + jTextField1.getText().substring(h[0].getStartOffset(), h[0].getEndOffset()));
        }
    }