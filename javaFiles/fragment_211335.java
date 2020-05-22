interface Item {
    void accept(ItemVisitor itemVisitor);
}

abstract class ItemWithName implements Item {
    private final String name;

    /*CTOR*/

    public String getName() {
        return name;
    }
}

class SpinnerLeafItem extends ItemWithName {
    /*CTOR*/

    public void accept(ItemVisitor itemVisitor) {
       itemVisitor.visit(this);
    }
}

class CompositeSpinnerItem extends ItemWithName {
    private final String name;
    private final List<Item> innerItems;

    /*CTOR*/

    public void accept(ItemVisitor itemVisitor) {
       itemVisitor.visit(this);
    }

    /* Getter for inner items */
}

class EditTextItem extends ItemWithName {
    /*CTOR*/

    public void accept(ItemVisitor itemVisitor) {
       itemVisitor.visit(this);
    }
}