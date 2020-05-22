HtmlOutcomeTargetLink link = new HtmlOutcomeTargetLink();
link.setValue("Edit");
link.setOutcome("edit");
UIParameter param = new UIParameter();
param.setName("id");
param.setValue("500");
link.getChildren().add(param);