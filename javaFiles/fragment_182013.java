quizTF.addCaretListener(new CaretListener() {
    public void caretUpdate(CaretEvent ev) {
        calculateB.setEnabled(!quizTF.getText().isEmpty() && !exerTF.getText().isEmpty() && ...);
    }
});

// code here