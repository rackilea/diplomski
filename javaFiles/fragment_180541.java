private void saveValue(MutableIssue issue, String valueToSave, CustomField
        customField) throws FieldLayoutStorageException {

    issue.setCustomFieldValue(customField, valueToSave);

    Map<String, ModifiedValue> modifiedFields = issue.getModifiedFields();

    FieldLayoutItem fieldLayoutItem =
    ComponentManager.getInstance().getFieldLayoutManager().getFieldLayout(issue).getFieldLayoutItem(
            customField);

    DefaultIssueChangeHolder issueChangeHolder = new DefaultIssueChangeHolder();

    final ModifiedValue modifiedValue = (ModifiedValue) modifiedFields.get(customField.getId());

    customField.updateValue(fieldLayoutItem, issue, modifiedValue, issueChangeHolder);
}