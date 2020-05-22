// you used this ctor when creating the view programmatically
public CompassView(Context context) {
    this(context, null);
    // add additional initialization here
}

// this constructor is needed for the class to be used in XML layout files!
public CompassView(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
    // add additional initialization here
}

// this constructor is needed for the class to be used in XML layout files,
//  with a class-specific base style
public CompassView(Context context, AttributeSet attributeSet, int defStyle) {
    super(context, attributeSet, defStyle);
    // add additional initialization here
}