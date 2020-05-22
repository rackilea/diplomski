public static boolean isModalDialogShowing()
{
    Window[] windows = Window.getWindows();
    if( windows != null ) { // don't rely on current implementation, which at least returns [0].
        for( Window w : windows ) {
            if( w.isShowing() && w instanceof Dialog && ((Dialog)w).isModal() )
                return true;
        }
    }
    return false;
}