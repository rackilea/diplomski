@Inject Event<CategoryUpdate> categoryUpdateEvent;

public void someTransactionalMethod() {
    CategoryUpdate categoryUpdate = new CategoryUpdate();
    categoryUpdateEvent.fire(categoryUpdate);
}