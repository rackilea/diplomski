TextArea textArea = new TextArea(){
        @Override
        public void replaceText(IndexRange range, String text) {
            super.replaceText(range, text.replaceAll("\r", "\n"));
        }
        @Override
        public void replaceText(int start, int end, String text) {
            super.replaceText(start, end, text.replaceAll("\r", "\n"));
        }
        @Override
        public void replaceSelection(String replacement) {
            super.replaceSelection(replacement.replaceAll("\r", "\n"));
        }
    });