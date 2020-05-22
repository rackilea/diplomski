form.add(new DropDownChoice<Integer>("number",
  new AbstractReadOnlyModel<List<Integer>>() {
    public List<Integer> getObject() {
      return MyChoices.getAllAsInts();
    }
  }
);