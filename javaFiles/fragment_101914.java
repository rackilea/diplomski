final JTextArea textArea = new JTextArea();
    PrintStream printStream = new PrintStream( new OutputStream() {
        @Override
        public void write( final int b ) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textArea.append( "" + (char )b );
                    textArea.setCaretPosition( textArea.getText().length() );
                }
            });
        }
    } );
    System.setOut(printStream);