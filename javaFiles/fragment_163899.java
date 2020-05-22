...
    private Activity activity;

    public DateComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        activity = (Activity) getContext();

        // rest ommited
        initFields();
    }

...