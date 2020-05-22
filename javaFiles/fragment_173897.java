private void expandPrevious(Accordion acc) {
    int index = acc.getPanes().indexOf(acc.getExpandedPane());
    int newIndex = Math.max(index - 1, 0);
    acc.setExpandedPane(acc.getPanes().get(newIndex));
}

private void expandNext(Accordion acc) {
    int index = acc.getPanes().indexOf(acc.getExpandedPane());
    int newIndex = Math.min(index + 1, acc.getPanes().size() - 1);
    acc.setExpandedPane(acc.getPanes().get(newIndex));
}