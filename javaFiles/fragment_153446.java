BeanFieldGroup<MyEntity> binder;
    binder = new BeanFieldGroup<MyEntity>(MyEntity.class);
    MyEntity myEntity = new MyEntity();
    myEntity.setId(new MyEntityPK());
    binder.setItemDataSource(new BeanItem<MyEntity>(myEntity));
    binder.bind(new TextField(), "id.cdVariabile");