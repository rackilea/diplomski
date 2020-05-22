// instantiate a sortable JXList
final JXList list = new JXList(Locale.getAvailableLocales(), true);
list.setSortOrder(SortOrder.ASCENDING);

final JPopupMenu popup = new JPopupMenu();
popup.add(new JScrollPane(list));
popup.setFocusable(false);
final JTextField field = new JTextField(20);

// instantiate a PatternModel to map text --> pattern 
final PatternModel model = new PatternModel();
model.setMatchRule(PatternModel.MATCH_RULE_STARTSWITH);
// listener which to update the list's RowFilter on changes to the model's pattern property  
PropertyChangeListener modelListener = new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("pattern".equals(evt.getPropertyName())) {
            updateFilter((Pattern) evt.getNewValue());
        }
    }

    private void updateFilter(Pattern newValue) {
        RowFilter<Object, Integer> filter = null;
        if (newValue != null) {
            filter = RowFilters.regexFilter(newValue);
        }
        list.setRowFilter(filter);
    }
};
model.addPropertyChangeListener(modelListener);

// DocumentListener to update the model's rawtext property on changes to the field
DocumentListener documentListener = new DocumentListener() {

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateAfterDocumentChange();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateAfterDocumentChange();
    }

    private void updateAfterDocumentChange() {
        if (!popup.isVisible()) {
            popup.show(field, 0, field.getHeight());
        } 
        model.setRawText(field.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
};
field.getDocument().addDocumentListener(documentListener);