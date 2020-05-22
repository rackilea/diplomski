try {
    viewDataModel.setObjectType(this.buildObjectType(filteredObjectType,
            argA1Response.getData().getDataObject().getCategories().get(0).getObjectTypes().get(0)));

}
catch (Exception e) {
    String msg = "Exception occoured while buildng the Object Data Model";
    LOG.error(msg, e);
}