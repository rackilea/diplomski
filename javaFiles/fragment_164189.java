protected void onLoad() {
  HashMap<String, Widget> formWidgetHash = new HashMap<String, Widget>();
  FlexTable table = new FlexTable();
  FormPanel form = new FormPanel();
  form.setWidget(table);

  service.getFields(AysncCallbak<Fields> callback) {
    public void onSuccess(Fields result) {
      int i = 0;
      for(Object yo : fields.stuff()) {
        mkFormWidget(formWidgetHash, table, i++, yo);
      }
    }
  }
}