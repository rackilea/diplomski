public class MyDeckPanel extends DeckPanel {
  public HandlerRegistration addShowWidgetHandler(
      ShowWidgetEventHandler handler) {
    return addHandler(handler, ShowWidgetEvent.getType());
  }

  @Override
  public void showWidget(int index) {
    super.showWidget(index);
    fireEvent(new ShowWidgetEvent(index));
  }
}