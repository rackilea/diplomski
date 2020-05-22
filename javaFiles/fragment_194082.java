private JInternalFrame frame1;
private JInternalFrame frame2;
...

/**
 * invoked when the button used to show the first frame is clicked
 */
private void showFrame1() {
    if (frame1 == null) {
        frame1 = new JInternalFrame();
        // TODO initialize the frame
    }
    // TODO show the frame
}

// same for the other frames