private final HandlerRegistration handlerRegistration;

public BigPopup() {
  setWidget(uiBinder.createAndBindUi(this));
  handlerRegistration = Window.addResizeHandler(new ResizeHandler() {...});
  ...
}
@UiHandler("tstBtn")
void click(final ClickEvent event) {
   handlerRegistration.removeHandler();
   this.hide();
}