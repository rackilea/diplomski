@Override
public void actionPerformed(ActionEvent e) {
    List<Integer> selectedValues = jList.getSelectedValuesList();
    for (Integer selectedValue : selectedValues) {
        listModel.removeElement(selectedValue);
    }

    // method elsewhere that iterates through the listModel, calculates an average
    // and displays it
    calculateAndDisplayAverage();
}