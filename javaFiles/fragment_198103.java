LayoutStyle ls = gl.getLayoutStyle();

// Can be null if not already set.
if (ls == null) {
    // If not set, get the default style.
    ls = LayoutStyle.getInstance();
}

// What is the size of north gap if there is a JLabel?
System.out.format("North gap: %d", ls.getContainerGap(new JLabel(), SwingConstants.NORTH, null));