class Order {
    Integer orderNumber;
    Integer parentOrder;
    Integer productNumber;
    String  userComment;

    public Integer getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Integer getParentOrder() {
        return parentOrder;
    }
    public void setParentOrder(int parentOrder) {
        this.parentOrder = parentOrder;
    }
    public Integer getProductNumber() {
        return productNumber;
    }
    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
    public String getUserComment() {
        return userComment;
    }
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}