public class ButtonEnablement implements DocumentListener {

        private ButtonModel buttonModel;
        private List<Document> documents = new ArrayList<Document>();

        public ButtonEnablement(ButtonModel buttonModel) {
            this.buttonModel = buttonModel;
        }

        public void addDocument(Document document) {
            document.addDocumentListener(this);
            this.documents.add(document);
            documentChanged();
        }

        public void documentChanged() {
            boolean buttonEnabled = false;
            for (Document document : documents) {
                if (document.getLength() > 0) {
                    buttonEnabled = true;
                    break;
                }
            }
            buttonModel.setEnabled(buttonEnabled);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            documentChanged();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            documentChanged();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            documentChanged();
        }
    }