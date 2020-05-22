public class CustomSwipeDeckAdapter extends SwipeDeckAdapter {

    private AppCompatTextView mNameAgeLabel;

    public SwipeDeckAdapter(List<String> data, Context context, AppCompatTextView textview) {
      mNameAgeLabel = textView;
      […]
    }

    public View getView(final int position, View View, ViewGroup parent) {
      […]
      mNameAgeLabel.setText();
    }