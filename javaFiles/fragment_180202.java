public void onMessage(Message message) {
    Visitor v = new Visitor() {
        public void visit(Event1 event) {
            // Execute Processing 1
        }
        public void visit(Event2 event) {
            // Execute Processing 2
        }
        public void visit(Event3 event) {
            // Execute Processing 3
        }
    }
    event.visit(v);
}