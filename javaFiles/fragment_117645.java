@Override
public void itemStateChanged(ItemEvent arg0) {
    Object src = arg0.getSource();
    if (src == questions) {
        ref();
    }
}

@SuppressWarnings("unchecked")
public void ref() {
    questions.removeAllItems();
    answers.removeAllItems();

    ...