private void mkFormWidget(
  HashMap formWidgetHash, FlexTable table, int row, Object yo) {

  // LHS of table is field prompt
  String prompt = resolvePrompt(yo);
  table.setText(row, 0, prompt);
  Widget formWidget;
  if (yo instanceof Boolean){
    formWidget = new CheckBox();
  }
  else { ...
  }
  else { ...
  }
  else {
    formWidget = new TextBox();
  }

  table.setWidget(row, 1, w);
  formWidgetHash.put(prompt, w);
}

abstract protected String resolvePrompt(Object o);