public class CustomColorPreference extends Preference
{
    int backgroundColor = Color.BLACK;

    public CustomColorPreference(Context context) {
        super(context);
    }

    public CustomColorPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCustomBackgroundColor(int color)
    {
        backgroundColor = color;
    }

    @Override
    public View getView(View convertView, ViewGroup parent)
    {
        View v = super.getView(convertView, parent);

        // v.setBackgroundColor(backgroundColor); // set background color of whole view
        ImageView ivNameTextColor = (ImageView)v.findViewById(R.id.ivNameTextColor);
        ivNameTextColor.setBackgroundColor(backgroundColor);

        return v;
    }
}