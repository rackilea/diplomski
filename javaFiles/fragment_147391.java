DropDownChoice<String> ddc = new DropDownChoice<String>("ddc", model, Arrays.asList("a", "b", "c"));
ddc.add(new AjaxFormComponentUpdatingBehavior("onchange") {
    @Override
    protected void onUpdate(AjaxRequestTarget target) {
        System.out.println("selected: " + model.getObject());
    }
});