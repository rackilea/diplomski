abstract class MyAbstractClass <T extends GeneralItem> {
    abstract public void removeItem(T item, String reason);
}

class MySubclass extends MyAbstractClass<SpecificItemThatExtendsGeneralItem> {
    @Override
    public void removeItem(SpecificItemThatExtendsGeneralItem item,
            String reason) {
        // ...
    }
}