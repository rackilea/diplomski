if (event.getType() == BoxEvent.Type.ITEM_UPLOAD) {
    BoxItem uploadedItem = (BoxItem) event.getSource();

    // Do something with the uploaded item. For this example, we'll just print
    // out its name.
    BoxItem.Info itemInfo = uploadedItem.getInfo();
    System.out.format("A file named '%s' was uploaded.\n", itemInfo.getName());
}