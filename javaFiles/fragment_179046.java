mEntityListModel = getMyEntityModel();

T[] items = (T[]) Array.newInstance(type, mEntityListModel.getSize());

for (int i = 0; i < items.length; i++) {
    items[i] = mEntityListModel.getElementAt(i);
}
mComboBoxModel = new DefaultComboBoxModel<T>(items);