public class JLists {

    public static <T> void moveSelection(JList<T> fromList, JList<T> toList) {
        ListSelectionModel fromSelection = fromList.getSelectionModel();
        ListModel<T> fromModel = fromList.getModel();
        ListModel<T> toModel = toList.getModel();
        DefaultListModel<T> newFromModel = createModelCopy(fromModel);
        DefaultListModel<T> newToModel = createModelCopy(toModel);

        int minSelection = fromSelection.getMinSelectionIndex();
        int maxSelection = fromSelection.getMaxSelectionIndex();

        int removedElements = 0;
        for (int i = minSelection; i <= maxSelection; i++) {
            if (fromSelection.isSelectedIndex(i)) {
                T elementAt = fromModel.getElementAt(i);
                newToModel.addElement(elementAt);
                newFromModel.removeElementAt(i - removedElements);
                removedElements++;
            }
        }

        fromList.setModel(newFromModel);
        toList.setModel(newToModel);
    }

    private static <T> DefaultListModel<T> createModelCopy(
            ListModel<T> listModel) {
        DefaultListModel<T> newListModel = new DefaultListModel<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            T elementAt = listModel.getElementAt(i);
            newListModel.addElement(elementAt);
        }
        return newListModel;
    }
}