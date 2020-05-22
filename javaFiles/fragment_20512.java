@PrePersist
public void beforeCreate() {
    if(created == null)
        created = new Timestamp(System.currentTimeMillis());

    for(OrderCustomField orderCustomField : getOrderCustomFields())
        orderCustomField.setOrder(this);
}