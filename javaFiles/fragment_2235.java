ItemList itemList= (ItemList)
            getSupportFragmentManager().findFragmentByTag("Items")
            .getChildFragmentManager().findFragmentByTag("itemListTag");
if(itemList != null) {
    itemList.listChange();
}