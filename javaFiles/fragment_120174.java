public void preProcessForItemInserting(Item item){
    Store store = getStoreDao().get( item.getStoreId() );
    Set<Category> storeCategories = store.getCategories();
    Set<Category> itemCategories = item.getCategories();
    storeCategories.addAll( itemCategories );
    getStoreDao().save( store );
}

//it is a little bit more complex than inserting logic
public void preProcessForItemUpdating(Item item){...}

//it is a little bit more complex than inserting logic
public void preProcessForItemDeleting(Item item){...}