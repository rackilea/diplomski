private Object selectSpecificItem(TreeObject treeObject) {
    Object result = null;
    for (TreeObject to : treeObject.getChildren()) {
        Object data = to.getData();
        if (data instanceof PaymentOffice) {
            PaymentOffice po = (PaymentOffice) data;
            if (po.getCode().equals(getModelObject().getLocation())) {
                return to;
            }
        } else if (to.getChildren().length > 0) {
            result = selectSpecificItem(to);
            if (result != null) {
                return result;
            }
        }
    }
    return result;
}