public class HSV extends HorizontalScrollView {

  private final ScrollViewDelegate<HorizontalScrollView> delegate;

  public HSV(Context context) {
      super(context);
      this.delegate = new ScrollViewDelegate<HorizontalScrollView>(this);
  }
  // do stuff with this.delegate
}

public class VSV extends ScrollView {

  private final ScrollViewDelegate<ScrollView> delegate;

  public VSV(Context context) {
      super(context);
      this.delegate = new ScrollViewDelegate<ScrollView>(this);
  }
}