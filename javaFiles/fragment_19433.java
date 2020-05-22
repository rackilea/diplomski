public boolean onCreateOptionsMenu(android.view.Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.cool_menu, menu);
    getLayoutInflater().setFactory(new Factory() {
        public View onCreateView(String name, Context context,
                AttributeSet attrs) {

            if (name.equalsIgnoreCase(
                    "com.android.internal.view.menu.IconMenuItemView")) {
                try {
                    LayoutInflater li = LayoutInflater.from(context);
                    final View view = li.createView(name, null, attrs);
                    new Handler().post(new Runnable() {
                        public void run() {
                            // set the background drawable if you want that
                            //or keep it default -- either an image, border
                            //gradient, drawable, etc.
                            view.setBackgroundResource(R.drawable.myimage);
                            ((TextView) view).setTextSize(20); 

                            // set the text color
                            Typeface face = Typeface.createFromAsset(
                                    getAssets(),"OldeEnglish.ttf");     
                            ((TextView) view).setTypeface(face);
                            ((TextView) view).setTextColor(Color.RED);
                        }
                    });
                    return view;
                } catch (InflateException e) {
                    //Handle any inflation exception here
                } catch (ClassNotFoundException e) {
                    //Handle any ClassNotFoundException here
                }
            }
            return null;
        }
    });
    return super.onCreateOptionsMenu(menu);
}