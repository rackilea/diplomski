//approach loaded
final InvalidationListener lis = new InvalidationListener() {               
@Override
public void invalidated(Observable observable) {
    //here it is changing
    if(sp.isFocused())
        lastFocusedNode.requestFocus();//take the focus away
    }
};