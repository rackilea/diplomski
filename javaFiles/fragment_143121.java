access.addItem(item0, new DataCallback() {
    @Override
    public void changed(Item item0, ItemState state) {

        //where items[] is the item created using group.addItem("item"+index) in the constructor
        JIArray jiArray = items[1].read(true).getValue().getObjectAsArray(); 
        Object[] arrayObj = (Object[]) jiArray.getArrayInstance();

        // arrayObj contains the value (or values) of the item 

        for (Object v : arrayObj) {

        }
    }
});