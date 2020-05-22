public final class View {

private GUIElement mModularElement;

public final void setModularElement(final GUIElement pModularElement) {
    this.mModularElement = pModularElement;
}

public final GUIElement getModularElement() {
    return this.mModularElement;
}

public final void onRender(final GUIVariable pGUIVariable) {
    this.getModularElement().draw(pGUIVariable);
}