// lets suppose this is your adapter (which obviously has
//to be a custom one which extends from on of the main
//adapters BaseAdapter, CursorAdapter, ArrayAdapter, etc.)

// every adapter has a getView method that you will have to overwrite
// I guess you know what I'm talking about
public View getView( args blah blah ){
    View theView;
    // do stuff with the view

    // before returning, set the background
    theView.setBackgroundResource(R.drawable.the_custom_background);

    return theView;
}