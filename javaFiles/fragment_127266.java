DefaultTableModel model = (DefaultTableModel) table.getModel();
for (int i = 0; i < model.getRowCount(); i++) {
    CurrentPrevious curPrev = (CurrentPrevious) model.getValueAt(i, 0);
    curPrev.setPrevious(curPrev.getCurrent());
    Double newCurrent = getRandomDouble();
    curPrev.setCurrent(newCurrent);
    model.setValueAt(curPrev, i, 0);
}