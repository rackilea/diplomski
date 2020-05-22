if (userPressedFullScreenButton) {
    frame.getGraphicsConfiguration().getDevice().setFullScreenWindow(frame);
    System.out.println("User switched to full-screen.");
} else if (userPressedManagedWindowButton) {
    frame.getGraphicsConfiguration().getDevice().setFullScreenWindow(null);
    System.out.println("User switched out of full-screen.");
}