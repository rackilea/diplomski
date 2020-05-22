abstract class MenuElement {

    public abstract int getType();

    public abstract long getId();
}

public void test() {
    LinkedHashMap<Integer, LinkedHashMap <Long, MenuElement>> mMenuElement = new LinkedHashMap<>();
    MenuElement me;
    mMenuElement.get(me.getType()).put(me.getId(), me);