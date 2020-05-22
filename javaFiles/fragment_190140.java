@Override
protected void updateItem(T item, boolean empty) {
    System.out.println("getItem(): " + getItem());
    if (getItem() != null) {
        final BooleanExpression be = flashExtractor.apply(getItem());
        if (be != null) {
            be.removeListener(flashListener);
        }
    }

    super.updateItem(item, empty);

    if(empty) {
        flasherChanged(false);  
    }
    else if (getItem() != null) {
        final BooleanExpression be = flashExtractor.apply(getItem());
        if (be != null) {
            be.addListener(flashListener);
            flasherChanged(be.get());
        }
    }

    recentItemChanged();
}