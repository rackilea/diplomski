PlainDocument d=(PlainDocument) jPasswordField1.getDocument();
d.setDocumentFilter(new DocumentFilter(){

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String string =fb.getDocument().getText(0, fb.getDocument().getLength())+text;

            if(string.length() <= 4)
            super.replace(fb, offset, length, text, attrs); //To change body of generated methods, choose Tools | Templates.
        }



    });