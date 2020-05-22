mEntityListModel.addListDataListener(new DataListener());// make a better MVC solution if you like

private class DataListener implements ListDataListener {

    @Override
    public void intervalAdded(ListDataEvent e) {
        mComboBoxModel.insertElementAt(mEntityListModel.getElementAt(e.getIndex0()), e.getIndex0());
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        Object deletedElement = mComboBoxModel.getElementAt(e.getIndex0());

        // Clear the combobox selection, if the item is deleted!
        if (mSelectionManager.isSelected(deletedElement)) {
            mSelectionManager.setSelectedItem(null);
        }
        mComboBoxModel.removeElementAt(e.getIndex0());
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        intervalRemoved(e);
        intervalAdded(e);
    }

}