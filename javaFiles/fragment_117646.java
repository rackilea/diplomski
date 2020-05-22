public void ref() {
    // first remove all item listeners
    ItemListener[] questionListeners = questions.getItemListeners();
    ItemListener[] answerListeners = answers.getItemListeners();

    for (ItemListener l : questionListeners) {
        questions.removeItemListener(l);
    }
    for (ItemListener l : answerListeners) {
        answers.removeItemListener(l);
    }

    // change state
    questions.removeAllItems();
    answers.removeAllItems();

    // re-add all listeners
    for (ItemListener l : questionListeners) {
        questions.addItemListener(l);
    }
    for (ItemListener l : answerListeners) {
        answers.addItemListener(l);
    }

    ...