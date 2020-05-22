@Override
public void replaceAllChildren(....) {
  SafeHtml html = renderRowValues(...);

  ....

  fireValueChangeEvent();
}