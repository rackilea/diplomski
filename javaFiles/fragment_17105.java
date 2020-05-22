private ImageHandle createImage(ElementFactory factory) {
    ImageHandle image = factory.newImage(null);
    image.setURL("\"http://example.com/\" + row[\"B\"]  + \".png\"");
    HideRule rule = StructureFactory.createHideRule();
    rule.setFormat("all");
    rule.setExpression("row[\"A\"] == \"X\"");
    image.getPropertyHandle(IReportItemModel.VISIBILITY_PROP).addItem(rule);
    return image;
}