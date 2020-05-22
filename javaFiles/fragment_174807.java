form.add(new DropDownChoice<MyChoices>("number", Arrays.asList(MyChoices.values()) {
  public IModel<?> initModel() {
    final IModel<Integer> model = (IModel<Integer>)super.initModel();

    return new IModel<MyChoice>() {
      public MyChoice getObject() {
        return MyChoice.fromInt(model.getObject());
      }

      public void setObject(MyChoice myChoice) {
        model.setObject(myChoice.toInt());
      }
    };
  }
);