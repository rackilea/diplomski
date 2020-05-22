ImageView foo;
RelativeLayout.LayoutParams fooParams;
for (int i = 0; i < levels; i++) { 
    foo = new ImageView(context);
    foo.setId(10 + i);
    fooParams = (RelativeLayout.LayoutParams) foo.getLayoutParams(); // I don't understand why you are trying to get params of which hasn't been specified before.
    // If I were you, I would do like:
    fooParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    if (i == 0) {
        fooParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    } else {
        fooParams.addRule(RelativeLayout.RIGHT_OF, foo.getId()-1);
    }
    foo.setImageBitmap(yourBitmap); // Set bitmap.
    foo.setLayoutParams(fooParams);
    layoutFoo.addView(foo);
}