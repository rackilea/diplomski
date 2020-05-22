public interface AutoFocusTransferDelegate {
        public boolean shouldTransferFocus(Document doc);
    }

    public interface AutoFocusTransferObserver {
        public void focusTransferShouldOccur(Document doc);
    }

    public class AutoFocusTransferHandler implements DocumentListener {

        private AutoFocusTransferListener listener;
        private AutoFocusTransferDelegate delegate;

        public AutoFocusTransferHandler(AutoFocusTransferListener listener, AutoFocusTransferDelegate delegate) {
            this.listener = listener;
            this.delegate = delegate;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        public void checkForTransfer(Document doc) {
            if (delegate != null && delegate.shouldTransferFocus(doc)) {
                if (listener != null) {
                    listener.focusTransferShouldOccur(doc);
                }
            }
        }

    }