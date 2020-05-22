public class CheckedLinearLayout extends RelativeLayout implements
        Checkable {

    private boolean isChecked;
    private List<Checkable> checkableViews;

    public CheckedLinearLayout (Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    public CheckedLinearLayout (Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public CheckedLinearLayout (Context context, int checkableId) {
        super(context);
        initialise(null);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
        for (Checkable c : checkableViews) {
            c.setChecked(isChecked);
        }
    }
    public void toggle() {
        this.isChecked = !this.isChecked;
        for (Checkable c : checkableViews) {
            c.toggle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            findCheckableChildren(this.getChildAt(i));
        }
    }

    /**
     * Read the custom XML attributes
     */
    private void initialise(AttributeSet attrs) {
        this.isChecked = false;
        this.checkableViews = new ArrayList<Checkable>(5);
    }

    /**
     * Add to our checkable list all the children of the view that implement the
     * interface Checkable
     */
    private void findCheckableChildren(View v) {
        if (v instanceof Checkable) {
            this.checkableViews.add((Checkable) v);
        }

        if (v instanceof ViewGroup) {
            final ViewGroup vg = (ViewGroup) v;
            final int childCount = vg.getChildCount();
            for (int i = 0; i < childCount; ++i) {
                findCheckableChildren(vg.getChildAt(i));
            }
        }
    }
}