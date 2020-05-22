textItem.addChangedHandler(new ChangedHandler() {

  @Override
  public void onChanged(ChangedEvent event) {
    String input = (String) event.getValue();
    AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.OR, new Criterion[]{
      // ICONTAINS = ignores case
      new Criterion("firstName", OperatorId.ICONTAINS, input),
      new Criterion("lastName", OperatorId.ICONTAINS, input)
    });

    listGrid.filterData(criteria);
  }
});