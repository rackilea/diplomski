wmc = new WebMarkupContainer("wmc") {
   @Override public void onConfigure() {
     super.onConfigure();
     setVisible(isExamsSuccess.getModelObject());
   }
}
wmc.setOutputMarkupPlaceholderTag(true);