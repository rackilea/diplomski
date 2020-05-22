private final BooleanProperty menuShowing = new SimpleBooleanProperty(this, "menuShowing", false);
public final void setMenuShowing(boolean showing) {
    menuShowing.set(showing);
}
public final boolean isMenuShowing() {
    return menuShowing.get();
}
public BooleanProperty menuShowingProperty() {
    return menuShowing ;
}