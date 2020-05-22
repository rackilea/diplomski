/**
 * Checks that the component is not a Window instance.
 */
 private void checkNotAWindow(Component comp){
    if (comp instanceof Window) {
       throw new IllegalArgumentException("adding a window to a container");
     }
 }