@Override
        public void run() {
            // System.out.println("Running!");
            commandArea.setHighlighter(new DefaultHighlighter());
            while (matcher.find()) {
                for (int i = 0; i < matcher.groupCount() + 1; i++) {
                    try {
                        int start = matcher.start(i);
                        int end = matcher.end(i);
                        System.out.println("start=" + start + " end=" + end);
                        commandArea.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(CommandPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }