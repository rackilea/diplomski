/**
 * Searches for all children of the given component which are instances of the given class.
 *
 * @param aRoot start object for search.
 * @param aClass class to search.
 * @param <E> class of component.
 * @return list of all children of the given component which are instances of the given class. Never null.
 */
public static <E> List<E> getAllChildrenOfClass(Container aRoot, Class<E> aClass) {
    final List<E> result = new ArrayList<E>();
    final Component[] children = aRoot.getComponents();
    for (final Component c : children) {
        if (aClass.isInstance(c)) {
            result.add(aClass.cast(c));
        }
        if (c instanceof Container) {
            result.addAll(getAllChildrenOfClass((Container) c, aClass));
        }
    }
    return result;
}

/** 
 * Finds the button by its text.
 * @param aParent container for button search.
 * @param aText text of button.
 * @return button with the given text or null if no such button found.
 */
public static JButton findButtonByText(Container aParent, String aText) {
    List<JButton> buttons = getAllChildrenOfClass(aParent, JButton.class);
    for (JButton btn : buttons) {
        if (btn.getText().equals(aText)) {
           return btn;
        }
    }
    return null;
}