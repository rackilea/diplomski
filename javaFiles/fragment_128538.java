public abstract class ScrollViewDelegate<T extends FrameLayout> {
  private final T view;
  private LinearLayout L;
  private AbsoluteLayout A;

  public ScrollViewWrapper(T view) {
    this.view = view;
    L = new LinearLayout(view.getContext());   // or pass as parameter
    A = new AbsoluteLayout(view.getContext()); // or pass as parameter
  }

  void update_scroll() {
      view.removeView(L);
      view.addView(L, 0);
      L.removeView(A);
      L.addView(A);
      A.invalidate();
      L.invalidate();
      view.invalidate();
      view.requestLayout();
  }
  // ...
}