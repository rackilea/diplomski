public void setImage (Image image) {
    checkWidget ();
    if (image != null && image.isDisposed ()) error (SWT.ERROR_INVALID_ARGUMENT);
    super.setImage (image);
    double /*float*/ width = 0;
    if (image == null) {
        view.setImage (null);
    } else {
        /*
         * Feature in Cocoa.  If the NSImage object being set into the view is
         * the same NSImage object that is already there then the new image is
         * not taken.  This results in the view's image not changing even if the
         * NSImage object's content has changed since it was last set into the
         * view.  The workaround is to temporarily set the view's image to null
         * so that the new image will then be taken.
         */
        NSImage current = view.image ();
        if (current != null && current.id == image.handle.id) {
            view.setImage (null);
        }
        view.setImage (image.handle);
        if (visible) {
            width = image.handle.size ().width + BORDER;
        }
    }
    item.setLength (width);
}